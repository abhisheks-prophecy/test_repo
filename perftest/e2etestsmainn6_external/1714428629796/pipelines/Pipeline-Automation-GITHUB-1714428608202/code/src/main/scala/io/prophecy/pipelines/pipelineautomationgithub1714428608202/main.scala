package io.prophecy.pipelines.pipelineautomationgithub1714428608202

import io.prophecy.libs._
import io.prophecy.pipelines.pipelineautomationgithub1714428608202.config._
import io.prophecy.pipelines.pipelineautomationgithub1714428608202.udfs.UDFs._
import io.prophecy.pipelines.pipelineautomationgithub1714428608202.udfs.PipelineInitCode._
import io.prophecy.pipelines.pipelineautomationgithub1714428608202.graph._
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
      .appName("Pipeline-Automation-GITHUB-1714428608202")
      .config("spark.default.parallelism",             "4")
      .config("spark.sql.legacy.allowUntypedScalaUDF", "true")
      .enableHiveSupport()
      .getOrCreate()
    val context = Context(spark, config)
    spark.conf.set("prophecy.metadata.pipeline.uri",
                   "pipelines/Pipeline-Automation-GITHUB-1714428608202"
    )
    registerUDFs(spark)
    MetricsCollector.instrument(
      spark,
      "pipelines/Pipeline-Automation-GITHUB-1714428608202"
    ) {
      apply(context)
    }
  }

}
