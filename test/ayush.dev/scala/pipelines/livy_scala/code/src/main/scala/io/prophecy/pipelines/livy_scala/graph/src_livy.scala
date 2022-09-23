package io.prophecy.pipelines.livy_scala.graph

import io.prophecy.libs._
import io.prophecy.pipelines.livy_scala.config.ConfigStore._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import java.time._

object src_livy {

  def apply(spark: SparkSession): DataFrame =
    spark.read
      .format("csv")
      .option("header", true)
      .option("sep",    ",")
      .schema(
        StructType(
          Array(
            StructField("year",                 StringType, true),
            StructField("industry_code_ANZSIC", StringType, true),
            StructField("industry_name_ANZSIC", StringType, true),
            StructField("rme_size_grp",         StringType, true),
            StructField("variable",             StringType, true),
            StructField("value",                StringType, true),
            StructField("unit",                 StringType, true)
          )
        )
      )
      .load("file:/storage/workflowdata/annual-enterprise")

}
