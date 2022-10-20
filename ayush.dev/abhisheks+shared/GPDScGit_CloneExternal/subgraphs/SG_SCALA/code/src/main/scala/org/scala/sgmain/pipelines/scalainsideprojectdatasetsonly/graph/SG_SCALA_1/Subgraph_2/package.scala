package org.scala.sgmain.pipelines.scalainsideprojectdatasetsonly.graph.SG_SCALA_1

import io.prophecy.libs._
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.graph.SG_SCALA_1.Subgraph_2.Subgraph_3
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._
package object Subgraph_2 {

  def apply(spark: SparkSession, in0: DataFrame): DataFrame = {
    val df_Reformat_6 = Reformat_6(spark,       in0)
    val df_Subgraph_3 = Subgraph_3.apply(spark, df_Reformat_6)
    df_Subgraph_3
  }

}
