package io.prophecy.pipelines.automationchetanexternalpipclone.graph

import io.prophecy.libs._
import io.prophecy.pipelines.automationchetanexternalpipclone.functions.PipelineInitCode._
import io.prophecy.pipelines.automationchetanexternalpipclone.graph.Subgraph_1.config._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._
package object Subgraph_1 {

  def apply(context: Context, in0: DataFrame): DataFrame = {
    val df_reformat_customer_info = reformat_customer_info(context, in0)
    df_reformat_customer_info
  }

}
