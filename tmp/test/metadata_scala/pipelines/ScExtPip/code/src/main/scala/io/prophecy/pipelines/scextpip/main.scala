package io.prophecy.pipelines.scextpip

import io.prophecy.libs._
import io.prophecy.pipelines.scextpip.config.ConfigStore._
import io.prophecy.pipelines.scextpip.config._
import io.prophecy.pipelines.scextpip.udfs.UDFs._
import io.prophecy.pipelines.scextpip.udfs._
import io.prophecy.pipelines.scextpip.graph._
import io.prophecy.pipelines.scextpip.graph.Subgraph_1
import io.prophecy.pipelines.scextpip.graph.testsg_1
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object Main {

  def apply(spark: SparkSession): Unit = {
    val df_src_this_project  = src_this_project(spark)
    val df_Subgraph_1        = Subgraph_1.apply(spark, df_src_this_project)
    val df_customers_orders  = customers_orders(spark)
    val df_Reformat_4        = Reformat_4(spark,       df_src_this_project)
    val df_Reformat_5        = Reformat_5(spark,       df_customers_orders)
    val df_src_sharedproject = src_sharedproject(spark)
    val df_Reformat_1        = Reformat_1(spark,       df_src_sharedproject)
    val df_testsg_1          = testsg_1.apply(spark,   df_src_this_project)
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
    spark.conf.set("prophecy.metadata.pipeline.uri", "693/pipelines/ScExtPip")
    MetricsCollector.start(spark,                    "693/pipelines/ScExtPip")
    apply(spark)
    MetricsCollector.end(spark)
  }

}
