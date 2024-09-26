package io.prophecy.pipelines.kmlk

import io.prophecy.libs._
import io.prophecy.pipelines.kmlk.config._
import io.prophecy.pipelines.kmlk.functions.UDFs._
import io.prophecy.pipelines.kmlk.functions.PipelineInitCode._
import io.prophecy.pipelines.kmlk.graph._
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
      .appName("kmlk")
      .config("spark.default.parallelism",             "4")
      .config("spark.sql.legacy.allowUntypedScalaUDF", "true")
      .enableHiveSupport()
      .getOrCreate()
    val context = Context(spark, config)
    spark.conf.set("prophecy.metadata.pipeline.uri", "pipelines/kmlk")
    registerUDFs(spark)
    MetricsCollector.instrument(spark, "pipelines/kmlk") {
      apply(context)
    }
  }

}
