import io.prophecy.libs._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import config.ConfigStore._
import udfs.UDFs._
import udfs._
import graph._

object Main {

  def apply(spark: SparkSession): Unit = {
    val df_Source_2     = Source_2(spark)
    val df_Filter_1_1_1 = Filter_1_1_1(spark, df_Source_2)
    val df_Join_3       = Join_3(spark,       df_Source_2, df_Filter_1_1_1)
    val df_Source_1     = Source_1(spark)
    val df_Filter_1_1   = Filter_1_1(spark,   df_Source_1)
    val df_Source_0     = Source_0(spark)
    val df_Filter_1     = Filter_1(spark,     df_Source_0)
    val df_Join_1       = Join_1(spark,       df_Source_0, df_Filter_1)
    Target_1(spark, df_Join_1)
    val df_Source_4         = Source_4(spark)
    val df_Filter_1_1_1_1_1 = Filter_1_1_1_1_1(spark, df_Source_4)
    val df_Join_5           = Join_5(spark,           df_Source_4, df_Filter_1_1_1_1_1)
    val df_Source_3         = Source_3(spark)
    val df_Filter_1_1_1_1   = Filter_1_1_1_1(spark,   df_Source_3)
    Target_1_1_1_1_1(spark, df_Join_5)
    val df_Join_4 = Join_4(spark, df_Source_3, df_Filter_1_1_1_1)
    Target_1_1_1_1(spark, df_Join_4)
    Target_1_1_1(spark,   df_Join_3)
    val df_Join_2 = Join_2(spark, df_Source_1, df_Filter_1_1)
    Target_1_1(spark, df_Join_2)
  }

  def main(args: Array[String]): Unit = {
    import config._
    ConfigStore.Config = ConfigurationFactoryImpl.fromCLI(args)
    val spark: SparkSession = SparkSession
      .builder()
      .appName("Prophecy Workflow")
      .config("spark.default.parallelism", "4")
      .enableHiveSupport()
      .getOrCreate()
    apply(spark)
  }

}
