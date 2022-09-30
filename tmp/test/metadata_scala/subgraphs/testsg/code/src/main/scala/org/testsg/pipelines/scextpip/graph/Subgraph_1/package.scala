package org.testsg.pipelines.scextpip.graph

import io.prophecy.libs._
import io.prophecy.pipelines.scextpip.graph.Subgraph_1.Subgraph_2
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._
package object Subgraph_1 {

  def apply(spark: SparkSession, in0: DataFrame): DataFrame = {
    val df_Reformat_2 = Reformat_2(spark,       in0)
    val df_Subgraph_2 = Subgraph_2.apply(spark, df_Reformat_2)
    df_Subgraph_2
  }

}
