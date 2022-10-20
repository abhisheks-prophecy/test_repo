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

object Reformat_4 {

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
      col("c_struct")
    )

}
