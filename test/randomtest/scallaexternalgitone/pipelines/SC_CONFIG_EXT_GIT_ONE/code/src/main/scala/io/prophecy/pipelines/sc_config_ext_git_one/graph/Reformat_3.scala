package io.prophecy.pipelines.sc_config_ext_git_one.graph

import io.prophecy.libs._
import io.prophecy.pipelines.sc_config_ext_git_one.config.ConfigStore._
import io.prophecy.pipelines.sc_config_ext_git_one.udfs.UDFs._
import io.prophecy.pipelines.sc_config_ext_git_one.udfs._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object Reformat_3 {

  def apply(spark: SparkSession, in: DataFrame): DataFrame =
    in.select(
      col("c_config_str"),
      col("c_config_bool"),
      col("c_config_int"),
      col("c_config_float"),
      col("c_config_double"),
      col("c_config_sparkexpression"),
      col("c_lookup"),
      col("c_udf1")
    )

}
