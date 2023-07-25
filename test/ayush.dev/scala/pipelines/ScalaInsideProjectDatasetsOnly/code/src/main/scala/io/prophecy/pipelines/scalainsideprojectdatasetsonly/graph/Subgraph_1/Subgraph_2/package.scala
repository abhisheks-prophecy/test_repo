package io.prophecy.pipelines.scalainsideprojectdatasetsonly.graph.Subgraph_1

import io.prophecy.libs._
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.graph.Subgraph_1.Subgraph_2.config._
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.graph.Subgraph_1.Subgraph_2.Subgraph_3
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.graph.Subgraph_1.Subgraph_2.Subgraph_3.config.{
  Context => Subgraph_3_Context
}
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._
package object Subgraph_2 {

  def apply(context: Context, in0: DataFrame): DataFrame = {
    val df_Reformat_6 = Reformat_6(context, in0)
    val df_Subgraph_3 = Subgraph_3.apply(
      Subgraph_3_Context(context.spark, context.config.Subgraph_3),
      df_Reformat_6
    )
    df_Subgraph_3
  }

}
