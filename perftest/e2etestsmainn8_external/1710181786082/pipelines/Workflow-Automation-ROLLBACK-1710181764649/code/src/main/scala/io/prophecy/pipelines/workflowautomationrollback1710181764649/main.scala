package io.prophecy.pipelines.workflowautomationrollback1710181764649

import io.prophecy.libs._
import io.prophecy.pipelines.workflowautomationrollback1710181764649.config._
import io.prophecy.pipelines.workflowautomationrollback1710181764649.udfs.UDFs._
import io.prophecy.pipelines.workflowautomationrollback1710181764649.udfs.PipelineInitCode._
import io.prophecy.pipelines.workflowautomationrollback1710181764649.graph._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object Main {
  def apply(context: Context): Unit = {}

  def main(args:     Array[String]): Unit = {
    val config = ConfigurationFactoryImpl.getConfig(args)
    val spark: SparkSession = SparkSession
      .builder()
      .appName("Prophecy Pipeline")
      .config("spark.default.parallelism",             "4")
      .config("spark.sql.legacy.allowUntypedScalaUDF", "true")
      .enableHiveSupport()
      .getOrCreate()
      .newSession()
    val context = Context(spark, config)
    spark.conf.set("prophecy.metadata.pipeline.uri",
                   "pipelines/Workflow-Automation-ROLLBACK-1710181764649"
    )
    registerUDFs(spark)
    try MetricsCollector.start(
      spark,
      "pipelines/Workflow-Automation-ROLLBACK-1710181764649",
      context.config
    )
    catch {
      case _: Throwable =>
        MetricsCollector.start(
          spark,
          "pipelines/Workflow-Automation-ROLLBACK-1710181764649"
        )
    }
    apply(context)
    MetricsCollector.end(spark)
  }

}
