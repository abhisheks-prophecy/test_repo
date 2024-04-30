package io.prophecy.pipelines.sc_config_ext_git_one.graph

import io.prophecy.libs._
import io.prophecy.pipelines.sc_config_ext_git_one.udfs.PipelineInitCode._
import io.prophecy.pipelines.sc_config_ext_git_one.udfs.UDFs._
import io.prophecy.pipelines.sc_config_ext_git_one.config.Context
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object Reformat_1 {

  def apply(context: Context, in: DataFrame): DataFrame = {
    val Config = context.config
    in.select(
      concat(lit(Config.c_string),  col("`c   short  --`")).as("c_config_str"),
      concat(lit(Config.c_boolean), col("`c   short  --`")).as("c_config_bool"),
      concat(lit(Config.c_int),     col("`c   short  --`")).as("c_config_int"),
      concat(lit(Config.c_float),   col("`c   short  --`")).as("c_config_float"),
      concat(lit(Config.c_double),  col("`c   short  --`"))
        .as("c_config_double"),
      expr(Config.c_spark_expression).as("c_config_sparkexpression"),
      lookup("TestLookup", col("c_timestamp"))
        .getField("c-decimal")
        .as("c_lookup"),
      int_udf(col("`c   short  --`")).as("c_udf1")
    )
  }

}
