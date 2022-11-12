package io.prophecy.pipelines.sc_config_ext_git_one

import io.prophecy.libs._
import io.prophecy.pipelines.sc_config_ext_git_one.config.ConfigStore._
import io.prophecy.pipelines.sc_config_ext_git_one.config._
import io.prophecy.pipelines.sc_config_ext_git_one.udfs.UDFs._
import io.prophecy.pipelines.sc_config_ext_git_one.udfs._
import io.prophecy.pipelines.sc_config_ext_git_one.graph._
import io.prophecy.pipelines.sc_config_ext_git_one.graph.Subgraph_1
import io.prophecy.pipelines.sc_config_ext_git_one.graph.testsubgraphmain1_1
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object Main {

  def apply(spark: SparkSession): Unit = {
    val df_csv_special_char = csv_special_char(spark)
    Lookup_1(spark, df_csv_special_char)
    val (df_Subgraph_1_out0, df_Subgraph_1_out1) =
      Subgraph_1.apply(spark, df_csv_special_char, df_csv_special_char)
    val (df_testsubgraphmain1_1_out0, df_testsubgraphmain1_1_out1) =
      testsubgraphmain1_1.apply(spark, df_Subgraph_1_out0, df_Subgraph_1_out1)
    val df_Reformat_1 = Reformat_1(spark, df_csv_special_char)
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
    spark.conf
      .set("prophecy.metadata.pipeline.uri", "pipelines/SC_CONFIG_EXT_GIT_ONE")
    MetricsCollector.start(spark,
                           spark.conf.get(
                             "prophecy.project.id"
                           ) + "/" + "pipelines/SC_CONFIG_EXT_GIT_ONE"
    )
    apply(spark)
    MetricsCollector.end(spark)
  }

}
