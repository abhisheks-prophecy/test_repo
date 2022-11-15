package io.prophecy.pipelines.kiranpipelinefirst

import io.prophecy.libs._
import io.prophecy.pipelines.kiranpipelinefirst.config.ConfigStore._
import io.prophecy.pipelines.kiranpipelinefirst.config._
import io.prophecy.pipelines.kiranpipelinefirst.udfs.UDFs._
import io.prophecy.pipelines.kiranpipelinefirst.udfs._
import io.prophecy.pipelines.kiranpipelinefirst.graph._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object Main {
  def apply(spark: SparkSession): Unit = {}

  def main(args:   Array[String]): Unit = {
    ConfigStore.Config = ConfigurationFactoryImpl.fromCLI(args)
    val spark: SparkSession = SparkSession
      .builder()
      .appName("Prophecy Pipeline")
      .config("spark.default.parallelism",             "4")
      .config("spark.sql.legacy.allowUntypedScalaUDF", "true")
      .enableHiveSupport()
      .getOrCreate()
      .newSession()
    spark.conf
      .set("prophecy.metadata.pipeline.uri", "pipelines/kiranPipelineFirst")
    MetricsCollector.start(spark,
                           spark.conf.get(
                             "prophecy.project.id"
                           ) + "/" + "pipelines/kiranPipelineFirst"
    )
    apply(spark)
    MetricsCollector.end(spark)
  }

}
