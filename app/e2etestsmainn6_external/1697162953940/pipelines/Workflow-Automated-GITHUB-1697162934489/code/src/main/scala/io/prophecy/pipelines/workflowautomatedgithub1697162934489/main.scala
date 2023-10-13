package io.prophecy.pipelines.workflowautomatedgithub1697162934489

import io.prophecy.libs._
import io.prophecy.pipelines.workflowautomatedgithub1697162934489.config.Context
import io.prophecy.pipelines.workflowautomatedgithub1697162934489.config._
import io.prophecy.pipelines.workflowautomatedgithub1697162934489.udfs.UDFs._
import io.prophecy.pipelines.workflowautomatedgithub1697162934489.udfs._
import io.prophecy.pipelines.workflowautomatedgithub1697162934489.udfs.PipelineInitCode._
import io.prophecy.pipelines.workflowautomatedgithub1697162934489.graph._
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
                   "pipelines/Workflow-Automated-GITHUB-1697162934489"
    )
    registerUDFs(spark)
    try MetricsCollector.start(
      spark,
      "pipelines/Workflow-Automated-GITHUB-1697162934489",
      context.config
    )
    catch {
      case _: Throwable =>
        MetricsCollector.start(
          spark,
          "pipelines/Workflow-Automated-GITHUB-1697162934489"
        )
    }
    apply(context)
    MetricsCollector.end(spark)
  }

}
