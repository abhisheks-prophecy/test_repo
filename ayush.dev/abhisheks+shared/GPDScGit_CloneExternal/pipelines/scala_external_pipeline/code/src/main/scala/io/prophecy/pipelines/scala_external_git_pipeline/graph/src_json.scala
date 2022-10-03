package io.prophecy.pipelines.scala_external_git_pipeline.graph

import io.prophecy.libs._
import io.prophecy.pipelines.scala_external_git_pipeline.config.ConfigStore._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object src_json {

  def apply(spark: SparkSession): DataFrame =
    spark.read
      .format("json")
      .schema(
        StructType(
          Array(
            StructField("account_flags",     StringType, true),
            StructField("account_open_date", StringType, true),
            StructField("country_code",      StringType, true),
            StructField("customer_id",       StringType, true),
            StructField("email",             StringType, true),
            StructField("first_name",        StringType, true),
            StructField("last_name",         StringType, true),
            StructField("phone",             StringType, true)
          )
        )
      )
      .load("dbfs:/Prophecy/qa_data/json/CustomersDatasetInput.json")

}
