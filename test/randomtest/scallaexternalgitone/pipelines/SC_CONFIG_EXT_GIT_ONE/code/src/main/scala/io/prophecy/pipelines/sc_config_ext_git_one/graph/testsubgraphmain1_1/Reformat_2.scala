package io.prophecy.pipelines.sc_config_ext_git_one.graph.testsubgraphmain1_1

import io.prophecy.libs._
import io.prophecy.pipelines.sc_config_ext_git_one.udfs.UDFs._
import io.prophecy.pipelines.sc_config_ext_git_one.graph.testsubgraphmain1_1.config.Context
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object Reformat_2 {

  def apply(context: Context, in: DataFrame): DataFrame =
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
      col("c_timestamp")
    )

}
