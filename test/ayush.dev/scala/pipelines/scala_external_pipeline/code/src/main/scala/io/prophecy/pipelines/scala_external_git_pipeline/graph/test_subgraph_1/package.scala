package io.prophecy.pipelines.scala_external_git_pipeline.graph

import io.prophecy.libs._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import java.time._
package object test_subgraph_1 {

  def apply(spark: SparkSession, in0: DataFrame): DataFrame = {
    val df_Reformat_2 = Reformat_2(spark, in0)
    df_Reformat_2
  }

}
