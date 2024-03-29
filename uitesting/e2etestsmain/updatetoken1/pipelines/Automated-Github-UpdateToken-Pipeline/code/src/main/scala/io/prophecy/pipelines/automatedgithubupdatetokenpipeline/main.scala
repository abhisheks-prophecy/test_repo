package io.prophecy.pipelines.automatedgithubupdatetokenpipeline

import io.prophecy.libs._
import io.prophecy.pipelines.automatedgithubupdatetokenpipeline.config.ConfigStore._
import io.prophecy.pipelines.automatedgithubupdatetokenpipeline.config._
import io.prophecy.pipelines.automatedgithubupdatetokenpipeline.udfs.UDFs._
import io.prophecy.pipelines.automatedgithubupdatetokenpipeline.udfs._
import io.prophecy.pipelines.automatedgithubupdatetokenpipeline.graph._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object Main {

  def apply(spark: SparkSession): Unit = {
    val df_Script_0 = Script_0(spark)
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
    spark.conf.set("prophecy.metadata.pipeline.uri",
                   "pipelines/Automated-Github-UpdateToken-Pipeline"
    )
    MetricsCollector.start(
      spark,
      spark.conf.get(
        "prophecy.project.id"
      ) + "/" + "pipelines/Automated-Github-UpdateToken-Pipeline"
    )
    apply(spark)
    MetricsCollector.end(spark)
  }

}
