package io.prophecy.pipelines.sc_config_ext_git_one.graph.Subgraph_1

import io.prophecy.libs._
import io.prophecy.pipelines.sc_config_ext_git_one.config.ConfigStore._
import io.prophecy.pipelines.sc_config_ext_git_one.udfs.UDFs._
import io.prophecy.pipelines.sc_config_ext_git_one.udfs._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object Limit_1 {
  def apply(spark: SparkSession, in: DataFrame): DataFrame = in.limit(10)
}
