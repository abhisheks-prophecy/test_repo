package io.prophecy.pipelines.workflowautomationgithub1739422903260

import io.prophecy.libs._
import io.prophecy.pipelines.workflowautomationgithub1739422903260.config._
import io.prophecy.pipelines.workflowautomationgithub1739422903260.functions.UDFs._
import io.prophecy.pipelines.workflowautomationgithub1739422903260.functions.PipelineInitCode._
import io.prophecy.pipelines.workflowautomationgithub1739422903260.graph._
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
      .appName("Workflow-Automation-GITHUB-1739422903260")
      .enableHiveSupport()
      .getOrCreate()
    val context = Context(spark, config)
    spark.conf.set("prophecy.metadata.pipeline.uri",
                   "pipelines/Workflow-Automation-GITHUB-1739422903260"
    )
    spark.conf.set("spark.default.parallelism",             "4")
    spark.conf.set("spark.sql.legacy.allowUntypedScalaUDF", "true")
    registerUDFs(spark)
    MetricsCollector.instrument(
      spark,
      "pipelines/Workflow-Automation-GITHUB-1739422903260"
    ) {
      apply(context)
    }
  }

}
