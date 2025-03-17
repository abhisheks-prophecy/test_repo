package io.prophecy.pipelines.automationgithubupdatetokenpipeline

import io.prophecy.libs._
import io.prophecy.pipelines.automationgithubupdatetokenpipeline.config._
import io.prophecy.pipelines.automationgithubupdatetokenpipeline.functions.UDFs._
import io.prophecy.pipelines.automationgithubupdatetokenpipeline.functions.PipelineInitCode._
import io.prophecy.pipelines.automationgithubupdatetokenpipeline.graph._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object Main {

  def apply(context: Context): Unit = {
    val df_Script_0 = Script_0(context)
  }

  def main(args: Array[String]): Unit = {
    val config = ConfigurationFactoryImpl.getConfig(args)
    val spark: SparkSession = SparkSession
      .builder()
      .appName("Automation-Github-UpdateToken-Pipeline")
      .enableHiveSupport()
      .getOrCreate()
    val context = Context(spark, config)
    spark.conf.set("prophecy.metadata.pipeline.uri",
                   "pipelines/Automation-Github-UpdateToken-Pipeline"
    )
    spark.conf.set("spark.default.parallelism",             "4")
    spark.conf.set("spark.sql.legacy.allowUntypedScalaUDF", "true")
    registerUDFs(spark)
    MetricsCollector.instrument(
      spark,
      "pipelines/Automation-Github-UpdateToken-Pipeline"
    ) {
      apply(context)
    }
  }

}
