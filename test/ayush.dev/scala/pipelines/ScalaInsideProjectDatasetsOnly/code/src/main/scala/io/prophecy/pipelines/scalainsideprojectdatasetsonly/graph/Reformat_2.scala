package io.prophecy.pipelines.scalainsideprojectdatasetsonly.graph

import io.prophecy.libs._
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.udfs.PipelineInitCode._
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.udfs.UDFs._
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.config.Context
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object Reformat_2 {

  def apply(context: Context, in: DataFrame): DataFrame =
    in.select(
      col("p_int"),
      col("p_long"),
      col("p_decimal"),
      col("p_float"),
      col("p_boolean"),
      col("p_double"),
      col("p_string"),
      col("p_date"),
      col("p_timestamp"),
      col("c_short")
    )

}
