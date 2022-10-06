package io.prophecy.pipelines.scextpip.graph

import io.prophecy.libs._
import io.prophecy.pipelines.scextpip.config.ConfigStore._
import io.prophecy.pipelines.scextpip.udfs.UDFs._
import io.prophecy.pipelines.scextpip.udfs._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object Reformat_4 {

  def apply(spark: SparkSession, in: DataFrame): DataFrame =
    in.select(
      col("`c   short  --`").as("c   short  --"),
      col("`c-int-column type`").as("c-int-column type"),
      col("`-- c-long`").as("-- c-long"),
      col("`c-decimal`").as("c-decimal"),
      col("`c  float`").as("c  float"),
      col("`c--boolean`").as("c--boolean"),
      col("`c- - -double`").as("c- - -double"),
      col("`c___-- string`").as("c___-- string"),
      col("`c  date`").as("c  date"),
      col("c_timestamp"),
      concat(col("c_timestamp"), lit(Config.c_string)).as("c_config")
    )

}
