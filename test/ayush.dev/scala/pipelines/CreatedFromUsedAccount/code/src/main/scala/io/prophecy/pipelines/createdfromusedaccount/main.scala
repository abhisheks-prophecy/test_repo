package io.prophecy.pipelines.createdfromusedaccount

import io.prophecy.libs._
import io.prophecy.pipelines.createdfromusedaccount.config.ConfigStore._
import io.prophecy.pipelines.createdfromusedaccount.config._
import io.prophecy.pipelines.createdfromusedaccount.udfs.UDFs._
import io.prophecy.pipelines.createdfromusedaccount.udfs._
import io.prophecy.pipelines.createdfromusedaccount.graph._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object Main {

  def apply(spark: SparkSession): Unit = {
    val df_src_avro   = src_avro(spark)
    val df_Reformat_1 = Reformat_1(spark, df_src_avro)
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
    spark.conf
      .set("prophecy.metadata.pipeline.uri", "pipelines/CreatedFromUsedAccount")
    MetricsCollector.start(spark,
                           spark.conf.get(
                             "prophecy.project.id"
                           ) + "/" + "pipelines/CreatedFromUsedAccount"
    )
    apply(spark)
    MetricsCollector.end(spark)
  }

}
