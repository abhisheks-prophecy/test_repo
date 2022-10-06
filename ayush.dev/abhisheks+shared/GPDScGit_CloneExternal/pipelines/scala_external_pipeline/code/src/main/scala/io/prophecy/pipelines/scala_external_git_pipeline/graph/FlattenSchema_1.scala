package io.prophecy.pipelines.scala_external_git_pipeline.graph

import io.prophecy.libs._
import io.prophecy.pipelines.scala_external_git_pipeline.config.ConfigStore._
import io.prophecy.pipelines.scala_external_git_pipeline.udfs.UDFs._
import io.prophecy.pipelines.scala_external_git_pipeline.udfs._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object FlattenSchema_1 {

  def apply(spark: SparkSession, in: DataFrame): DataFrame =
    in.withColumn("c_array-string  _ string",
                  explode_outer(col("c_array-string  _ string"))
      )
      .withColumn("c_array--long", explode_outer(col("c_array--long")))
      .withColumn(
        "c_struct -- _  -c_array_int - of a struct ",
        explode_outer(col("c_struct -- _  .c_array_int - of a struct "))
      )
      .select(
        col("c_array-string  _ string"),
        col("c_array--long"),
        col("c_struct -- _  .c_short - of a struct")
          .as("c_struct -- _  -c_short - of a struct"),
        col("c_struct -- _  .c_array_int - of a struct ")
          .as("c_struct -- _  -c_array_int - of a struct ")
      )

}
