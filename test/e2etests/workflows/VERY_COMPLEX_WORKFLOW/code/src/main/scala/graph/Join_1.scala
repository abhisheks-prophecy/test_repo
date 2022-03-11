package graph

import io.prophecy.libs._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import config.ConfigStore._
import udfs.UDFs._
import udfs._

object Join_1 {

  def apply(spark: SparkSession, in0: DataFrame, in1: DataFrame): DataFrame =
    in0
      .as("in0")
      .join(in1.as("in1"),
            col("in0.customer_id") === col("in1.customer_id"),
            "inner"
      )
      .select(
        col("in0.customer_id").as("customer_id"),
        col("in0.first_name").as("first_name"),
        col("in0.last_name").as("last_name"),
        col("in0.phone").as("phone"),
        col("in0.email").as("email"),
        col("in0.country_code").as("country_code"),
        col("in0.account_open_date").as("account_open_date"),
        col("in0.account_flags").as("account_flags")
      )

}
