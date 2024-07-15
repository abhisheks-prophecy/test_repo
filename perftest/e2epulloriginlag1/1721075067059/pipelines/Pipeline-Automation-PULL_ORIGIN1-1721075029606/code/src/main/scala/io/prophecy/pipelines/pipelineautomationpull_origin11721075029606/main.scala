package io.prophecy.pipelines.pipelineautomationpull_origin11721075029606

import io.prophecy.libs._
import io.prophecy.pipelines.pipelineautomationpull_origin11721075029606.config._
import io.prophecy.pipelines.pipelineautomationpull_origin11721075029606.functions.UDFs._
import io.prophecy.pipelines.pipelineautomationpull_origin11721075029606.functions.PipelineInitCode._
import io.prophecy.pipelines.pipelineautomationpull_origin11721075029606.graph._
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
      .appName("Pipeline-Automation-PULL_ORIGIN1-1721075029606")
      .config("spark.default.parallelism",             "4")
      .config("spark.sql.legacy.allowUntypedScalaUDF", "true")
      .enableHiveSupport()
      .getOrCreate()
    val context = Context(spark, config)
    spark.conf.set("prophecy.metadata.pipeline.uri",
                   "pipelines/Pipeline-Automation-PULL_ORIGIN1-1721075029606"
    )
    registerUDFs(spark)
    MetricsCollector.instrument(
      spark,
      "pipelines/Pipeline-Automation-PULL_ORIGIN1-1721075029606"
    ) {
      apply(context)
    }
  }

}
