package org.d1.pipelines.scala_external_git_pipeline.graph.test_subgraph_1

import io.prophecy.libs._
import io.prophecy.pipelines.scala_external_git_pipeline.config.ConfigStore._
import io.prophecy.pipelines.scala_external_git_pipeline.udfs.UDFs._
import io.prophecy.pipelines.scala_external_git_pipeline.udfs._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import java.time._

object Reformat_2 {

  def apply(spark: SparkSession, in: DataFrame): DataFrame =
    in.select(
      col("c_short"),
      col("c_int"),
      col("c_long"),
      col("c_decimal"),
      col("c_float"),
      col("c_boolean"),
      col("c_double"),
      col("c_string"),
      col("c_date"),
      col("c_timestamp"),
      col("c_array_int"),
      col("c_array_string"),
      col("c_array_long"),
      col("c_array_boolean"),
      col("c_array_date"),
      col("c_array_timestamp"),
      col("c_array_float"),
      col("c_array_decimal"),
      col("c_struct")
    )

}
