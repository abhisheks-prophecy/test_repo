package io.prophecy.pipelines.workflowautomatedrollback1693599515884

import io.prophecy.libs._
import io.prophecy.pipelines.workflowautomatedrollback1693599515884.config.Context
import io.prophecy.pipelines.workflowautomatedrollback1693599515884.config._
import io.prophecy.pipelines.workflowautomatedrollback1693599515884.udfs.UDFs._
import io.prophecy.pipelines.workflowautomatedrollback1693599515884.udfs._
import io.prophecy.pipelines.workflowautomatedrollback1693599515884.udfs.PipelineInitCode._
import io.prophecy.pipelines.workflowautomatedrollback1693599515884.graph._
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
                   "pipelines/Workflow-Automated-ROLLBACK-1693599515884"
    )
    registerUDFs(spark)
    try MetricsCollector.start(
      spark,
      "pipelines/Workflow-Automated-ROLLBACK-1693599515884",
      context.config
    )
    catch {
      case _: Throwable =>
        MetricsCollector.start(
          spark,
          "pipelines/Workflow-Automated-ROLLBACK-1693599515884"
        )
    }
    apply(context)
    MetricsCollector.end(spark)
  }

}
