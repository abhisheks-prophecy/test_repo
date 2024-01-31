package org.scala.sgmain.pipelines.scalainsideprojectdatasetsonly.graph.SG_SCALA_2.Subgraph_2

import io.prophecy.libs._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._
package object Subgraph_3 {

  def apply(spark: SparkSession, in0: DataFrame): DataFrame = {
    val df_Filter_2 = Filter_2(spark, in0)
    df_Filter_2
  }

}
