package io.prophecy.pipelines.scalainsideprojectdatasetsonly.graph

import io.prophecy.libs._
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.config.ConfigStore._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object src_parquet {

  def apply(spark: SparkSession): DataFrame =
    spark.read
      .format("parquet")
      .load("dbfs:/Prophecy/qa_data/parquet/all_type_no_partition")

}
