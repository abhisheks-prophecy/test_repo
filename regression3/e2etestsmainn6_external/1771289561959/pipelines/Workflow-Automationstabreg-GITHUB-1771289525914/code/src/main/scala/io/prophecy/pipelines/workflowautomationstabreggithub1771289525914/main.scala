package io.prophecy.pipelines.workflowautomationstabreggithub1771289525914

import io.prophecy.libs._
import io.prophecy.pipelines.workflowautomationstabreggithub1771289525914.config._
import io.prophecy.pipelines.workflowautomationstabreggithub1771289525914.functions.UDFs._
import io.prophecy.pipelines.workflowautomationstabreggithub1771289525914.functions.PipelineInitCode._
import io.prophecy.pipelines.workflowautomationstabreggithub1771289525914.graph._
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
      .appName("Workflow-Automationstabreg-GITHUB-1771289525914")
      .enableHiveSupport()
      .getOrCreate()
    val context = Context(spark, config)
    spark.conf.set("prophecy.metadata.pipeline.uri",
                   "pipelines/Workflow-Automationstabreg-GITHUB-1771289525914"
    )
    spark.conf.set("spark.default.parallelism",             "4")
    spark.conf.set("spark.sql.legacy.allowUntypedScalaUDF", "true")
    registerUDFs(spark)
    MetricsCollector.instrument(
      spark,
      "pipelines/Workflow-Automationstabreg-GITHUB-1771289525914"
    ) {
      apply(context)
    }
  }

}
