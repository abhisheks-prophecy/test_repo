package io.prophecy.pipelines.workflowautomatedgithub1666723325715

import io.prophecy.libs._
import io.prophecy.pipelines.workflowautomatedgithub1666723325715.config.ConfigStore._
import io.prophecy.pipelines.workflowautomatedgithub1666723325715.config._
import io.prophecy.pipelines.workflowautomatedgithub1666723325715.udfs.UDFs._
import io.prophecy.pipelines.workflowautomatedgithub1666723325715.udfs._
import io.prophecy.pipelines.workflowautomatedgithub1666723325715.graph._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object Main {

  def apply(spark: SparkSession): Unit = {
    val df_dataset_cust_in = dataset_cust_in(spark)
    val df_Filter_1        = Filter_1(spark, df_dataset_cust_in)
    dataset_out_40812(spark, df_Filter_1)
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
                   "pipelines/Workflow-Automated-GITHUB-1666723325715"
    )
    MetricsCollector.start(
      spark,
      spark.conf.get(
        "prophecy.project.id"
      ) + "/" + "pipelines/Workflow-Automated-GITHUB-1666723325715"
    )
    apply(spark)
    MetricsCollector.end(spark)
  }

}
