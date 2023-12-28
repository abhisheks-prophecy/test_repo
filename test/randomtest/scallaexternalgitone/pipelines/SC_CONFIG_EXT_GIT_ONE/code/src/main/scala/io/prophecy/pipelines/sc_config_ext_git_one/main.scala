package io.prophecy.pipelines.sc_config_ext_git_one

import io.prophecy.libs._
import io.prophecy.pipelines.sc_config_ext_git_one.config.Context
import io.prophecy.pipelines.sc_config_ext_git_one.config._
import io.prophecy.pipelines.sc_config_ext_git_one.udfs.UDFs._
import io.prophecy.pipelines.sc_config_ext_git_one.udfs._
import io.prophecy.pipelines.sc_config_ext_git_one.graph._
import io.prophecy.pipelines.sc_config_ext_git_one.graph.Subgraph_1
import io.prophecy.pipelines.sc_config_ext_git_one.graph.testsubgraphmain1_1
import io.prophecy.pipelines.sc_config_ext_git_one.graph.Subgraph_1.config.{
  Context => Subgraph_1_Context
}
import io.prophecy.pipelines.sc_config_ext_git_one.graph.testsubgraphmain1_1.config.{
  Context => testsubgraphmain1_1_Context
}
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object Main {

  def apply(context: Context): Unit = {
    val df_csv_special_char = csv_special_char(context)
    Lookup_1(context, df_csv_special_char)
    val df_Reformat_1 = Reformat_1(context, df_csv_special_char)
    val df_Reformat_3 = Reformat_3(context, df_Reformat_1)
    val (df_Subgraph_1_out0, df_Subgraph_1_out1) = Subgraph_1.apply(
      Subgraph_1_Context(context.spark, context.config.Subgraph_1),
      df_csv_special_char,
      df_csv_special_char
    )
    val (df_testsubgraphmain1_1_out0, df_testsubgraphmain1_1_out1) =
      testsubgraphmain1_1.apply(
        testsubgraphmain1_1_Context(context.spark,
                                    context.config.testsubgraphmain1_1
        ),
        df_Subgraph_1_out0,
        df_Subgraph_1_out1
      )
  }

  def main(args: Array[String]): Unit = {
    val config = ConfigurationFactoryImpl.fromCLI(args)
    val spark: SparkSession = SparkSession
      .builder()
      .appName("Prophecy Pipeline")
      .config("spark.default.parallelism",             "4")
      .config("spark.sql.legacy.allowUntypedScalaUDF", "true")
      .enableHiveSupport()
      .getOrCreate()
      .newSession()
    val context = Context(spark, config)
    spark.conf
      .set("prophecy.metadata.pipeline.uri", "pipelines/SC_CONFIG_EXT_GIT_ONE")
    registerUDFs(spark)
    MetricsCollector.start(spark, "pipelines/SC_CONFIG_EXT_GIT_ONE")
    apply(context)
    MetricsCollector.end(spark)
  }

}
