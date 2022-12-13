package io.prophecy.pipelines.workflowautomatedgithub1670960000180

import io.prophecy.libs._
import io.prophecy.pipelines.workflowautomatedgithub1670960000180.config.ConfigStore._
import io.prophecy.pipelines.workflowautomatedgithub1670960000180.config._
import io.prophecy.pipelines.workflowautomatedgithub1670960000180.udfs.UDFs._
import io.prophecy.pipelines.workflowautomatedgithub1670960000180.udfs._
import io.prophecy.pipelines.workflowautomatedgithub1670960000180.graph._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object Main {

  def apply(spark: SparkSession): Unit = {
    val df_Source_0 = Source_0(spark)
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
                   "pipelines/Workflow-Automated-GITHUB-1670960000180"
    )
    MetricsCollector.start(
      spark,
      spark.conf.get(
        "prophecy.project.id"
      ) + "/" + "pipelines/Workflow-Automated-GITHUB-1670960000180"
    )
    apply(spark)
    MetricsCollector.end(spark)
  }

}
