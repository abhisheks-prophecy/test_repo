package io.prophecy.pipelines.workflowautomatedrollback1673014119109

import io.prophecy.libs._
import io.prophecy.pipelines.workflowautomatedrollback1673014119109.config.ConfigStore._
import io.prophecy.pipelines.workflowautomatedrollback1673014119109.config.Context
import io.prophecy.pipelines.workflowautomatedrollback1673014119109.config._
import io.prophecy.pipelines.workflowautomatedrollback1673014119109.udfs.UDFs._
import io.prophecy.pipelines.workflowautomatedrollback1673014119109.udfs._
import io.prophecy.pipelines.workflowautomatedrollback1673014119109.graph._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object Main {

  def apply(context: Context): Unit = {
    val df_Source_0 = Source_0(context)
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
    spark.conf.set("prophecy.metadata.pipeline.uri",
                   "pipelines/Workflow-Automated-ROLLBACK-1673014119109"
    )
    MetricsCollector.start(spark,
                           "pipelines/Workflow-Automated-ROLLBACK-1673014119109"
    )
    apply(context)
    MetricsCollector.end(spark)
  }

}
