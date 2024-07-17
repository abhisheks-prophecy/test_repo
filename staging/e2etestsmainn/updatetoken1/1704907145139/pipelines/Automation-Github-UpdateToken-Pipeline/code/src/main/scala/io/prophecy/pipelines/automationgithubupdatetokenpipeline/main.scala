package io.prophecy.pipelines.automationgithubupdatetokenpipeline

import io.prophecy.libs._
import io.prophecy.pipelines.automationgithubupdatetokenpipeline.config.Context
import io.prophecy.pipelines.automationgithubupdatetokenpipeline.config._
import io.prophecy.pipelines.automationgithubupdatetokenpipeline.udfs.UDFs._
import io.prophecy.pipelines.automationgithubupdatetokenpipeline.udfs._
import io.prophecy.pipelines.automationgithubupdatetokenpipeline.udfs.PipelineInitCode._
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
      .appName("Prophecy Pipeline")
      .config("spark.default.parallelism",             "4")
      .config("spark.sql.legacy.allowUntypedScalaUDF", "true")
      .enableHiveSupport()
      .getOrCreate()
      .newSession()
    val context = Context(spark, config)
    spark.conf.set("prophecy.metadata.pipeline.uri",
                   "pipelines/Automation-Github-UpdateToken-Pipeline"
    )
    registerUDFs(spark)
    try MetricsCollector.start(
      spark,
      "pipelines/Automation-Github-UpdateToken-Pipeline",
      context.config
    )
    catch {
      case _: Throwable =>
        MetricsCollector.start(
          spark,
          "pipelines/Automation-Github-UpdateToken-Pipeline"
        )
    }
    apply(context)
    MetricsCollector.end(spark)
  }

}
