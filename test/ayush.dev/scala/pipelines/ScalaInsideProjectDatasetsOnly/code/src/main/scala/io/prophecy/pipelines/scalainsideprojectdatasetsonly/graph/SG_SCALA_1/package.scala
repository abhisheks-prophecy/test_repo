package io.prophecy.pipelines.scalainsideprojectdatasetsonly.graph

import io.prophecy.libs._
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.graph.SG_SCALA_1.config._
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.graph.SG_SCALA_1.Subgraph_2
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.graph.SG_SCALA_1.Subgraph_2.config.{
  Context => Subgraph_2_Context
}
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._
package object SG_SCALA_1 {

  def apply(context: Context, in0: DataFrame): DataFrame = {
    val df_Reformat_5 = Reformat_5(context, in0)
    val df_Subgraph_2 = Subgraph_2.apply(
      Subgraph_2_Context(context.spark, context.config.Subgraph_2),
      df_Reformat_5
    )
    df_Subgraph_2
  }

}
