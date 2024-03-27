package io.prophecy.pipelines.automationexternalpipclone.graph

import io.prophecy.libs._
import io.prophecy.pipelines.automationexternalpipclone.udfs.PipelineInitCode._
import io.prophecy.pipelines.automationexternalpipclone.graph.Subgraph_1.config._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._
package object Subgraph_1 {

  def apply(context: Context, in0: DataFrame): DataFrame = {
    val df_customers_reformat = customers_reformat(context, in0)
    df_customers_reformat
  }

}
