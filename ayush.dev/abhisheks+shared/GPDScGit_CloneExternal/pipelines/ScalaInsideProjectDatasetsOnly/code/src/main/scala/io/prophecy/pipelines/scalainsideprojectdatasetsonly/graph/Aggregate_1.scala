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

object Aggregate_1 {

  def apply(spark: SparkSession, in: DataFrame): DataFrame =
    in.groupBy(col("c_decimal"), col("c_float"), col("c_boolean"))
      .pivot(col("c_string"),    List("c_timestamp", "c_date"))
      .agg(first(col("c_short")).as("c_short"),
           first(col("c_long")).as("c_long")
      )

}
