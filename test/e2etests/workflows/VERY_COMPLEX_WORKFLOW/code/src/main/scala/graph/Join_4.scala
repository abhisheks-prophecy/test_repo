package graph

import io.prophecy.libs._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import config.ConfigStore._
import udfs.UDFs._
import udfs._

object Join_4 {

  def apply(spark: SparkSession, in0: DataFrame, in1: DataFrame): DataFrame =
    in0
      .as("in0")
      .join(in1.as("in1"), col("in0.c_int") === col("in1.c_int"), "inner")
      .select(
        col("in0.c_int").as("c_int"),
        col("in0.c_boolean").as("c_boolean"),
        col("in0.c_double").as("c_double"),
        col("in0.c_array").as("c_array"),
        col("in0.c_timestamp").as("c_timestamp"),
        col("in0.c_time").as("c_time")
      )

}
