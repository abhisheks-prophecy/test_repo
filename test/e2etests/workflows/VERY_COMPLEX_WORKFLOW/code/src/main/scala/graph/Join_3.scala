package graph

import io.prophecy.libs._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import config.ConfigStore._
import udfs.UDFs._
import udfs._

object Join_3 {

  def apply(spark: SparkSession, in0: DataFrame, in1: DataFrame): DataFrame =
    in0
      .as("in0")
      .join(in1.as("in1"), col("in0.city") === col("in1.city"), "inner")
      .select(
        col("in0.firstname").as("firstname"),
        col("in0.middlename").as("middlename"),
        col("in0.lastname").as("lastname"),
        col("in0.id").as("id"),
        col("in0.salary").as("salary"),
        col("in0.processed").as("processed"),
        col("in0.dob").as("dob"),
        col("in0.weight").as("weight"),
        col("in0.state").as("state"),
        col("in0.city").as("city"),
        col("in0.gender").as("gender")
      )

}
