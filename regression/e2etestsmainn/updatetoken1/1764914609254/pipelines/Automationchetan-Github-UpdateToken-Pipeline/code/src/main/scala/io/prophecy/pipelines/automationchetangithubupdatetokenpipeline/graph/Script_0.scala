package io.prophecy.pipelines.automationchetangithubupdatetokenpipeline.graph

import io.prophecy.libs._
import io.prophecy.pipelines.automationchetangithubupdatetokenpipeline.config.Context
import io.prophecy.pipelines.automationchetangithubupdatetokenpipeline.functions.UDFs._
import io.prophecy.pipelines.automationchetangithubupdatetokenpipeline.functions.PipelineInitCode._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object Script_0 {
  def apply(context: Context, in0: DataFrame): DataFrame = {
    val spark = context.spark
    val Config = context.config
    
    out0
  }

}
