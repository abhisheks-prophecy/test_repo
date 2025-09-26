package io.prophecy.pipelines.pipelineautomationpull_origin11758902471000

import io.prophecy.libs._
import io.prophecy.pipelines.pipelineautomationpull_origin11758902471000.config._
import io.prophecy.pipelines.pipelineautomationpull_origin11758902471000.functions.UDFs._
import io.prophecy.pipelines.pipelineautomationpull_origin11758902471000.functions.PipelineInitCode._
import io.prophecy.pipelines.pipelineautomationpull_origin11758902471000.graph._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object Main {

  def apply(context: Context): Unit = {
    val df_Script_0 = Script_0(context)
  }

  def main(args: Array[String]): Unit = {
    val config = ConfigurationFactoryImpl.getConfig(args)
    val spark: SparkSession = SparkSession
      .builder()
      .appName("Pipeline-Automation-PULL_ORIGIN1-1758902471000")
      .enableHiveSupport()
      .getOrCreate()
    val context = Context(spark, config)
    spark.conf.set("prophecy.metadata.pipeline.uri",
                   "pipelines/Pipeline-Automation-PULL_ORIGIN1-1758902471000"
    )
    spark.conf.set("spark.default.parallelism",             "4")
    spark.conf.set("spark.sql.legacy.allowUntypedScalaUDF", "true")
    registerUDFs(spark)
    MetricsCollector.instrument(
      spark,
      "pipelines/Pipeline-Automation-PULL_ORIGIN1-1758902471000"
    ) {
      apply(context)
    }
  }

}
