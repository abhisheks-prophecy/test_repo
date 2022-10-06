package io.prophecy.pipelines.scalainsideprojectdatasetsonly

import io.prophecy.libs._
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.config.ConfigStore._
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.config._
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.udfs.UDFs._
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.udfs._
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.graph._
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.graph.Subgraph_1
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.graph.SG_SCALA_1
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object Main {

  def apply(spark: SparkSession): Unit = {
    val df_src_parquet = src_parquet(spark)
    Lookup_1(spark, df_src_parquet)
    val df_src_delta         = src_delta(spark)
    val df_Reformat_4        = Reformat_4(spark,        df_src_parquet)
    val df_Reformat_1        = Reformat_1(spark,        df_Reformat_4)
    val df_Reformat_3        = Reformat_3(spark,        df_src_delta)
    val df_FlattenSchema_1   = FlattenSchema_1(spark,   df_src_delta)
    val df_Reformat_2        = Reformat_2(spark,        df_Reformat_3)
    val df_Filter_1          = Filter_1(spark,          df_Reformat_2)
    val df_SetOperation_1    = SetOperation_1(spark,    df_Filter_1,   df_Filter_1)
    val df_Aggregate_1       = Aggregate_1(spark,       df_Reformat_1)
    val df_Script_1          = Script_1(spark,          df_Reformat_3)
    val df_SchemaTransform_1 = SchemaTransform_1(spark, df_Script_1)
    val df_Join_1            = Join_1(spark,            df_Reformat_3, df_Reformat_3)
    val df_Deduplicate_1     = Deduplicate_1(spark,     df_Join_1)
    val (df_RowDistributor_1_out0, df_RowDistributor_1_out1) =
      RowDistributor_1(spark, df_Deduplicate_1)
    val df_SQLStatement_1 = SQLStatement_1(spark,   df_RowDistributor_1_out1)
    val df_Limit_1        = Limit_1(spark,          df_FlattenSchema_1)
    val df_Subgraph_1     = Subgraph_1.apply(spark, df_Reformat_3)
    val df_SG_SCALA_1     = SG_SCALA_1.apply(spark, df_Subgraph_1)
    val df_Repartition_1  = Repartition_1(spark,    df_RowDistributor_1_out0)
    dest_scala(spark, df_Aggregate_1)
  }

  def main(args: Array[String]): Unit = {
    ConfigStore.Config = ConfigurationFactoryImpl.fromCLI(args)
    val spark: SparkSession = SparkSession
      .builder()
      .appName("Prophecy Pipeline")
      .config("spark.default.parallelism",             "4")
      .config("spark.sql.legacy.allowUntypedScalaUDF", "true")
      .enableHiveSupport()
      .getOrCreate()
      .newSession()
    spark.conf.set("prophecy.metadata.pipeline.uri",
                   "pipelines/ScalaInsideProjectDatasetsOnly"
    )
    MetricsCollector.start(spark,
                           spark.conf.get(
                             "prophecy.project.id"
                           ) + "/" + "pipelines/ScalaInsideProjectDatasetsOnly"
    )
    apply(spark)
    MetricsCollector.end(spark)
  }

}
