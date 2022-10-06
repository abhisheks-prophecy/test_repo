package io.prophecy.pipelines.scalainsideprojectdatasetsonly.graph

import io.prophecy.libs._
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.config.ConfigStore._
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.udfs.UDFs._
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.udfs._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object Join_1 {

  def apply(spark: SparkSession, in0: DataFrame, in1: DataFrame): DataFrame =
    in0
      .as("in0")
      .join(in1.as("in1"), col("in0.p_short") === col("in1.p_short"), "inner")
      .select(
        col("in0.p_short").as("p_short"),
        col("in0.p_int").as("p_int"),
        col("in0.p_long").as("p_long"),
        col("in0.p_decimal").as("p_decimal"),
        col("in0.p_float").as("p_float"),
        col("in0.p_boolean").as("p_boolean"),
        col("in0.p_double").as("p_double"),
        col("in0.p_string").as("p_string"),
        col("in0.p_date").as("p_date"),
        col("in0.p_timestamp").as("p_timestamp"),
        col("in0.c_short").as("c_short")
      )

}
