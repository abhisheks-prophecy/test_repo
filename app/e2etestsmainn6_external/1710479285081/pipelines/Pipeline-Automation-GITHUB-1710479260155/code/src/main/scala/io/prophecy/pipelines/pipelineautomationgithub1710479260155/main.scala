package io.prophecy.pipelines.pipelineautomationgithub1710479260155

import io.prophecy.libs._
import io.prophecy.pipelines.pipelineautomationgithub1710479260155.config._
import io.prophecy.pipelines.pipelineautomationgithub1710479260155.udfs.UDFs._
import io.prophecy.pipelines.pipelineautomationgithub1710479260155.udfs.PipelineInitCode._
import io.prophecy.pipelines.pipelineautomationgithub1710479260155.graph._
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
                   "pipelines/Pipeline-Automation-GITHUB-1710479260155"
    )
    registerUDFs(spark)
    try MetricsCollector.start(
      spark,
      "pipelines/Pipeline-Automation-GITHUB-1710479260155",
      context.config
    )
    catch {
      case _: Throwable =>
        MetricsCollector.start(
          spark,
          "pipelines/Pipeline-Automation-GITHUB-1710479260155"
        )
    }
    apply(context)
    MetricsCollector.end(spark)
  }

}
