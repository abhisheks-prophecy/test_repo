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

object SchemaTransform_1 {

  def apply(spark: SparkSession, in: DataFrame): DataFrame =
    in.withColumn("a1", concat(col("p_short"), lit("5")))
      .drop("c_decimal")
      .withColumnRenamed("p_boolean", "p_boolean_new")

}
