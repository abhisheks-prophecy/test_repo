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

object FlattenSchema_1 {

  def apply(spark: SparkSession, in: DataFrame): DataFrame =
    in.withColumn("c_array_decimal",   explode_outer(col("c_array_decimal")))
      .withColumn("c_array_timestamp", explode_outer(col("c_array_timestamp")))
      .withColumn("c_struct-c_array_int",
                  explode_outer(col("c_struct.c_array_int"))
      )
      .select(col("c_array_decimal"),
              col("c_array_timestamp"),
              col("c_struct.c_array_int").as("c_struct-c_array_int")
      )

}
