package io.prophecy.pipelines.scala_external_git_pipeline

import io.prophecy.libs._
import io.prophecy.pipelines.scala_external_git_pipeline.config.ConfigStore._
import io.prophecy.pipelines.scala_external_git_pipeline.config._
import io.prophecy.pipelines.scala_external_git_pipeline.udfs.UDFs._
import io.prophecy.pipelines.scala_external_git_pipeline.udfs._
import io.prophecy.pipelines.scala_external_git_pipeline.graph._
import io.prophecy.pipelines.scala_external_git_pipeline.graph.test_subgraph_1
import io.prophecy.pipelines.scala_external_git_pipeline.graph.Subgraph_1
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import java.time._

object Main {

  def apply(spark: SparkSession): Unit = {
    val df_src_json            = src_json(spark)
    val df_Limit_1             = Limit_1(spark,               df_src_json)
    val df_src_orc             = src_orc(spark)
    val df_OrderBy_1           = OrderBy_1(spark,             df_src_orc)
    val df_src_avro            = src_avro(spark)
    val df_Reformat_1          = Reformat_1(spark,            df_src_avro)
    val df_src_parquet         = src_parquet(spark)
    val df_src_jdbc            = src_jdbc(spark)
    val df_Join_1              = Join_1(spark,                df_src_jdbc, df_src_jdbc)
    val df_Filter_1            = Filter_1(spark,              df_src_parquet)
    val df_test_subgraph_1     = test_subgraph_1.apply(spark, df_Filter_1)
    val df_src_catalog         = src_catalog(spark)
    val df_Subgraph_1          = Subgraph_1.apply(spark,      df_Filter_1)
    val df_src_parquet_complex = src_parquet_complex(spark)
    val df_FlattenSchema_1     = FlattenSchema_1(spark,       df_src_parquet_complex)
    val df_SetOperation_1 =
      SetOperation_1(spark, df_src_parquet_complex, df_src_parquet_complex)
    val df_src_csv = src_csv(spark)
    val (df_RowDistributor_1_out0, df_RowDistributor_1_out1) =
      RowDistributor_1(spark, df_src_catalog)
    val df_src_delta         = src_delta(spark)
    val df_SchemaTransform_1 = SchemaTransform_1(spark, df_src_delta)
    val df_Deduplicate_1     = Deduplicate_1(spark,     df_src_csv)
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
                   "pipelines/scala_external_git_pipeline"
    )
    MetricsCollector.start(spark,
                           spark.conf.get(
                             "prophecy.project.id"
                           ) + "/" + "pipelines/scala_external_git_pipeline"
    )
    apply(spark)
    MetricsCollector.end(spark)
  }

}
