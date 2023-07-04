package io.prophecy.pipelines.workflowautomatedgithub1688505916730

import io.prophecy.libs._
import io.prophecy.pipelines.workflowautomatedgithub1688505916730.config.Context
import io.prophecy.pipelines.workflowautomatedgithub1688505916730.config._
import io.prophecy.pipelines.workflowautomatedgithub1688505916730.udfs.UDFs._
import io.prophecy.pipelines.workflowautomatedgithub1688505916730.udfs._
import io.prophecy.pipelines.workflowautomatedgithub1688505916730.udfs.PipelineInitCode._
import io.prophecy.pipelines.workflowautomatedgithub1688505916730.graph._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object Main {
  def apply(context: Context): Unit = {}

  def main(args:     Array[String]): Unit = {
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
                   "pipelines/Workflow-Automated-GITHUB-1688505916730"
    )
    registerUDFs(spark)
    MetricsCollector.start(spark,
                           "pipelines/Workflow-Automated-GITHUB-1688505916730"
    )
    apply(context)
    MetricsCollector.end(spark)
  }

}
