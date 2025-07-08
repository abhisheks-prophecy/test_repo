package io.prophecy.pipelines.automationchetanexternalpipclone

import io.prophecy.libs._
import io.prophecy.pipelines.automationchetanexternalpipclone.config._
import io.prophecy.pipelines.automationchetanexternalpipclone.functions.UDFs._
import io.prophecy.pipelines.automationchetanexternalpipclone.functions.PipelineInitCode._
import io.prophecy.pipelines.automationchetanexternalpipclone.graph._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object Main {

  def apply(context: Context): Unit = {
    val df_Automationchetan_ExternalDataset_Clone =
      Automationchetan_ExternalDataset_Clone(context)
    val df_order_by_full_name =
      order_by_full_name(context, df_Automationchetan_ExternalDataset_Clone)
    val df_Subgraph_1 = Subgraph_1.apply(
      Subgraph_1.config.Context(context.spark, context.config.Subgraph_1),
      df_Automationchetan_ExternalDataset_Clone
    )
  }

  def main(args: Array[String]): Unit = {
    val config = ConfigurationFactoryImpl.getConfig(args)
    val spark: SparkSession = SparkSession
      .builder()
      .appName("Automationchetan-ExternalPip-Clone")
      .enableHiveSupport()
      .getOrCreate()
    val context = Context(spark, config)
    spark.conf.set("prophecy.metadata.pipeline.uri",
                   "pipelines/Automationchetan-ExternalPip-Clone"
    )
    spark.conf.set("spark.default.parallelism",             "4")
    spark.conf.set("spark.sql.legacy.allowUntypedScalaUDF", "true")
    registerUDFs(spark)
    MetricsCollector.instrument(spark,
                                "pipelines/Automationchetan-ExternalPip-Clone"
    ) {
      apply(context)
    }
  }

}
