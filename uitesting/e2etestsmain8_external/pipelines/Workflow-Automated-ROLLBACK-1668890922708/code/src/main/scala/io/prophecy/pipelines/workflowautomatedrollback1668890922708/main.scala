package io.prophecy.pipelines.workflowautomatedrollback1668890922708

import io.prophecy.libs._
import io.prophecy.pipelines.workflowautomatedrollback1668890922708.config.ConfigStore._
import io.prophecy.pipelines.workflowautomatedrollback1668890922708.config._
import io.prophecy.pipelines.workflowautomatedrollback1668890922708.udfs.UDFs._
import io.prophecy.pipelines.workflowautomatedrollback1668890922708.udfs._
import io.prophecy.pipelines.workflowautomatedrollback1668890922708.graph._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object Main {

  def apply(spark: SparkSession): Unit = {
    val df_Source_0 = Source_0(spark)
    val df_Source_2 = Source_2(spark)
    val df_Source_1 = Source_1(spark)
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
                   "pipelines/Workflow-Automated-ROLLBACK-1668890922708"
    )
    MetricsCollector.start(
      spark,
      spark.conf.get(
        "prophecy.project.id"
      ) + "/" + "pipelines/Workflow-Automated-ROLLBACK-1668890922708"
    )
    apply(spark)
    MetricsCollector.end(spark)
  }

}
