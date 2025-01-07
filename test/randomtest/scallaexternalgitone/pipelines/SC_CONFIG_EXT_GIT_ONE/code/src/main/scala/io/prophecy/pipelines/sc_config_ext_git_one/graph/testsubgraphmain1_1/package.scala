package io.prophecy.pipelines.sc_config_ext_git_one.graph

import io.prophecy.libs._
import io.prophecy.pipelines.sc_config_ext_git_one.udfs.PipelineInitCode._
import io.prophecy.pipelines.sc_config_ext_git_one.graph.testsubgraphmain1_1.config._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._
package object testsubgraphmain1_1 {

  def apply(context: Context, in0: DataFrame, in1: DataFrame): Subgraph2 = {
    val df_Reformat_2 = Reformat_2(context, in0)
    val df_Limit_1    = Limit_1(context,    in1)
    (df_Reformat_2, df_Limit_1)
  }

}
