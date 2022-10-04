package io.prophecy.pipelines.livy_scala.graph

import io.prophecy.libs._
import io.prophecy.pipelines.livy_scala.config.ConfigStore._
import io.prophecy.pipelines.livy_scala.udfs.UDFs._
import io.prophecy.pipelines.livy_scala.udfs._
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
      .join(in1.as("in1"), col("in0.unit") === col("in1.unit"), "inner")
      .select(
        col("in0.year").as("year"),
        col("in0.industry_code_ANZSIC").as("industry_code_ANZSIC"),
        col("in0.industry_name_ANZSIC").as("industry_name_ANZSIC"),
        col("in0.rme_size_grp").as("rme_size_grp"),
        col("in0.variable").as("variable"),
        col("in0.value").as("value"),
        col("in0.unit").as("unit")
      )

}
