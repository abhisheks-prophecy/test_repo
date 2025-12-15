package io.prophecy.pipelines.automationexternalpipclone

import io.prophecy.libs._
import io.prophecy.pipelines.automationexternalpipclone.config._
import io.prophecy.pipelines.automationexternalpipclone.functions.UDFs._
import io.prophecy.pipelines.automationexternalpipclone.functions.PipelineInitCode._
import io.prophecy.pipelines.automationexternalpipclone.graph._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object Main {

  def apply(context: Context): Unit = {
    val df_Automation_ExternalDataset_Clone = Automation_ExternalDataset_Clone(
      context
    )
    val df_sort_by_fullname =
      sort_by_fullname(context, df_Automation_ExternalDataset_Clone)
    val df_Subgraph_1 = Subgraph_1.apply(
      Subgraph_1.config.Context(context.spark, context.config.Subgraph_1),
      df_Automation_ExternalDataset_Clone
    )
  }

  def main(args: Array[String]): Unit = {
    val config = ConfigurationFactoryImpl.getConfig(args)
    val spark: SparkSession = SparkSession
      .builder()
      .appName("Automation-ExternalPip-Clone")
      .enableHiveSupport()
      .getOrCreate()
    val context = Context(spark, config)
    spark.conf.set("prophecy.metadata.pipeline.uri",
                   "pipelines/Automation-ExternalPip-Clone"
    )
    spark.conf.set("spark.default.parallelism",             "4")
    spark.conf.set("spark.sql.legacy.allowUntypedScalaUDF", "true")
    registerUDFs(spark)
    MetricsCollector.instrument(spark,
                                "pipelines/Automation-ExternalPip-Clone"
    ) {
      apply(context)
    }
  }

}
