package io.prophecy.pipelines.automatedexternalpipclone

import io.prophecy.libs._
import io.prophecy.pipelines.automatedexternalpipclone.config.ConfigStore._
import io.prophecy.pipelines.automatedexternalpipclone.config._
import io.prophecy.pipelines.automatedexternalpipclone.udfs.UDFs._
import io.prophecy.pipelines.automatedexternalpipclone.udfs._
import io.prophecy.pipelines.automatedexternalpipclone.graph._
import io.prophecy.pipelines.automatedexternalpipclone.graph.Subgraph_1
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object Main {

  def apply(spark: SparkSession): Unit = {
    val df_Automated_ExternalDataset_Clone = Automated_ExternalDataset_Clone(
      spark
    )
    val df_Subgraph_1 =
      Subgraph_1.apply(spark, df_Automated_ExternalDataset_Clone)
    val df_OrderBy_1 = OrderBy_1(spark, df_Automated_ExternalDataset_Clone)
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
                   "pipelines/Automated-ExternalPip-Clone"
    )
    MetricsCollector.start(spark,
                           spark.conf.get(
                             "prophecy.project.id"
                           ) + "/" + "pipelines/Automated-ExternalPip-Clone"
    )
    apply(spark)
    MetricsCollector.end(spark)
  }

}
