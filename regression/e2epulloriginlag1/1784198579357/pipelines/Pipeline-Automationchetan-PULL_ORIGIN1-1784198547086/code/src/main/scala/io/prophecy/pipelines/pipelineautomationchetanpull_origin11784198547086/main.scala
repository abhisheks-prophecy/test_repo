package io.prophecy.pipelines.pipelineautomationchetanpull_origin11784198547086

import io.prophecy.libs._
import io.prophecy.pipelines.pipelineautomationchetanpull_origin11784198547086.config._
import io.prophecy.pipelines.pipelineautomationchetanpull_origin11784198547086.functions.UDFs._
import io.prophecy.pipelines.pipelineautomationchetanpull_origin11784198547086.functions.PipelineInitCode._
import io.prophecy.pipelines.pipelineautomationchetanpull_origin11784198547086.graph._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object Main {

  def apply(context: Context): Unit = {
    val df_Script_0 = Script_0(context)
  }

  def main(args: Array[String]): Unit = {
    val config = ConfigurationFactoryImpl.getConfig(args)
    val spark: SparkSession = SparkSession
      .builder()
      .appName("Pipeline-Automationchetan-PULL_ORIGIN1-1784198547086")
      .enableHiveSupport()
      .getOrCreate()
    val context = Context(spark, config)
    spark.conf.set(
      "prophecy.metadata.pipeline.uri",
      "pipelines/Pipeline-Automationchetan-PULL_ORIGIN1-1784198547086"
    )
    spark.conf.set("spark.default.parallelism",             "4")
    spark.conf.set("spark.sql.legacy.allowUntypedScalaUDF", "true")
    registerUDFs(spark)
    MetricsCollector.instrument(
      spark,
      "pipelines/Pipeline-Automationchetan-PULL_ORIGIN1-1784198547086"
    ) {
      apply(context)
    }
  }

}
