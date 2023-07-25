package io.prophecy.pipelines.scalainsideprojectdatasetsonly

import io.prophecy.libs._
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.config.Context
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.config._
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.udfs.UDFs._
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.udfs._
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.udfs.PipelineInitCode._
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.graph._
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.graph.Subgraph_1
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.graph.SG_SCALA_1
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.graph.Subgraph_1.config.{
  Context => Subgraph_1_Context
}
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.graph.SG_SCALA_1.config.{
  Context => SG_SCALA_1_Context
}
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object Main {

  def apply(context: Context): Unit = {
    val df_src_parquet = src_parquet(context)
    Lookup_1(context, df_src_parquet)
    val df_src_delta         = src_delta(context)
    val df_Reformat_4        = Reformat_4(context,        df_src_parquet)
    val df_Reformat_1        = Reformat_1(context,        df_Reformat_4)
    val df_Reformat_3        = Reformat_3(context,        df_src_delta)
    val df_FlattenSchema_1   = FlattenSchema_1(context,   df_src_delta)
    val df_Reformat_2        = Reformat_2(context,        df_Reformat_3)
    val df_Filter_1          = Filter_1(context,          df_Reformat_2)
    val df_SetOperation_1    = SetOperation_1(context,    df_Filter_1,   df_Filter_1)
    val df_Aggregate_1       = Aggregate_1(context,       df_Reformat_1)
    val df_Script_1          = Script_1(context,          df_Reformat_3)
    val df_SchemaTransform_1 = SchemaTransform_1(context, df_Script_1)
    val df_Join_1            = Join_1(context,            df_Reformat_3, df_Reformat_3)
    val df_Deduplicate_1     = Deduplicate_1(context,     df_Join_1)
    val (df_RowDistributor_1_out0, df_RowDistributor_1_out1) =
      RowDistributor_1(context, df_Deduplicate_1)
    val df_SQLStatement_1 = SQLStatement_1(context, df_RowDistributor_1_out1)
    val df_Limit_1        = Limit_1(context,        df_FlattenSchema_1)
    val df_Subgraph_1 = Subgraph_1.apply(
      Subgraph_1_Context(context.spark, context.config.Subgraph_1),
      df_Reformat_3
    )
    val df_SG_SCALA_1 = SG_SCALA_1.apply(
      SG_SCALA_1_Context(context.spark, context.config.SG_SCALA_1),
      df_Subgraph_1
    )
    val df_Repartition_1 = Repartition_1(context, df_RowDistributor_1_out0)
    dest_scala(context, df_Aggregate_1)
  }

  def main(args: Array[String]): Unit = {
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
                   "pipelines/ScalaInsideProjectDatasetsOnly"
    )
    registerUDFs(spark)
    try MetricsCollector.start(spark,
                               "pipelines/ScalaInsideProjectDatasetsOnly",
                               context.config
    )
    catch {
      case _: Throwable =>
        MetricsCollector.start(spark,
                               "pipelines/ScalaInsideProjectDatasetsOnly"
        )
    }
    apply(context)
    MetricsCollector.end(spark)
  }

}
