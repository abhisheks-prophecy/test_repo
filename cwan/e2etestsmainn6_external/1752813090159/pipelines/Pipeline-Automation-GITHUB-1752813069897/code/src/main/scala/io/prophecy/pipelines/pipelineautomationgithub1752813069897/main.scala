package io.prophecy.pipelines.pipelineautomationgithub1752813069897

import io.prophecy.libs._
import io.prophecy.pipelines.pipelineautomationgithub1752813069897.config._
import io.prophecy.pipelines.pipelineautomationgithub1752813069897.functions.UDFs._
import io.prophecy.pipelines.pipelineautomationgithub1752813069897.functions.PipelineInitCode._
import io.prophecy.pipelines.pipelineautomationgithub1752813069897.graph._
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
      .appName("Pipeline-Automation-GITHUB-1752813069897")
      .enableHiveSupport()
      .getOrCreate()
    val context = Context(spark, config)
    spark.conf.set("prophecy.metadata.pipeline.uri",
                   "pipelines/Pipeline-Automation-GITHUB-1752813069897"
    )
    spark.conf.set("spark.default.parallelism",             "4")
    spark.conf.set("spark.sql.legacy.allowUntypedScalaUDF", "true")
    registerUDFs(spark)
    MetricsCollector.instrument(
      spark,
      "pipelines/Pipeline-Automation-GITHUB-1752813069897"
    ) {
      apply(context)
    }
  }

}
