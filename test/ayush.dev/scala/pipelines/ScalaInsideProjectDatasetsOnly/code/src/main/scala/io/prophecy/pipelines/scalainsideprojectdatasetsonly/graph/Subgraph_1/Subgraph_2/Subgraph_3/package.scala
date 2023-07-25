package io.prophecy.pipelines.scalainsideprojectdatasetsonly.graph.Subgraph_1.Subgraph_2

import io.prophecy.libs._
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.graph.Subgraph_1.Subgraph_2.Subgraph_3.config._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._
package object Subgraph_3 {

  def apply(context: Context, in0: DataFrame): DataFrame = {
    val df_Filter_2 = Filter_2(context, in0)
    df_Filter_2
  }

}
