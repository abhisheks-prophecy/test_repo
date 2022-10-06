package io.prophecy.pipelines.livy_scala

import io.prophecy.libs._
import io.prophecy.pipelines.livy_scala.config.ConfigStore._
import io.prophecy.pipelines.livy_scala.config._
import io.prophecy.pipelines.livy_scala.udfs.UDFs._
import io.prophecy.pipelines.livy_scala.udfs._
import io.prophecy.pipelines.livy_scala.graph._
import io.prophecy.pipelines.livy_scala.graph.Subgraph_1
import io.prophecy.pipelines.livy_scala.graph.SG_LIVY_1
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object Main {

  def apply(spark: SparkSession): Unit = {
    val df_src_livy      = src_livy(spark)
    val df_Deduplicate_1 = Deduplicate_1(spark,    df_src_livy)
    val df_Subgraph_1    = Subgraph_1.apply(spark, df_src_livy)
    val df_SG_LIVY_1     = SG_LIVY_1.apply(spark,  df_Subgraph_1)
    val df_Reformat_1    = Reformat_1(spark,       df_Deduplicate_1)
    val df_Join_1        = Join_1(spark,           df_Reformat_1, df_Reformat_1)
  }

  def main(args: Array[String]): Unit = {
    ConfigStore.Config = ConfigurationFactoryImpl.fromCLI(args)
    val spark: SparkSession = SparkSession
      .builder()
      .appName("Prophecy Pipeline")
      .config("spark.default.parallelism",             "4")
      .config("spark.sql.legacy.allowUntypedScalaUDF", "true")
      .enableHiveSupport()
      .getOrCreate()
      .newSession()
    spark.conf.set("prophecy.metadata.pipeline.uri", "pipelines/SclalaLivy")
    MetricsCollector.start(
      spark,
      spark.conf.get("prophecy.project.id") + "/" + "pipelines/SclalaLivy"
    )
    apply(spark)
    MetricsCollector.end(spark)
  }

}
