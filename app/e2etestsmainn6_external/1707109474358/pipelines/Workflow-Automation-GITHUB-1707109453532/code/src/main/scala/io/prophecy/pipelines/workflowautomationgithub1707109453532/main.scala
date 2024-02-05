package io.prophecy.pipelines.workflowautomationgithub1707109453532

import io.prophecy.libs._
import io.prophecy.pipelines.workflowautomationgithub1707109453532.config.Context
import io.prophecy.pipelines.workflowautomationgithub1707109453532.config._
import io.prophecy.pipelines.workflowautomationgithub1707109453532.udfs.UDFs._
import io.prophecy.pipelines.workflowautomationgithub1707109453532.udfs._
import io.prophecy.pipelines.workflowautomationgithub1707109453532.udfs.PipelineInitCode._
import io.prophecy.pipelines.workflowautomationgithub1707109453532.graph._
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
                   "pipelines/Workflow-Automation-GITHUB-1707109453532"
    )
    registerUDFs(spark)
    try MetricsCollector.start(
      spark,
      "pipelines/Workflow-Automation-GITHUB-1707109453532",
      context.config
    )
    catch {
      case _: Throwable =>
        MetricsCollector.start(
          spark,
          "pipelines/Workflow-Automation-GITHUB-1707109453532"
        )
    }
    apply(context)
    MetricsCollector.end(spark)
  }

}
