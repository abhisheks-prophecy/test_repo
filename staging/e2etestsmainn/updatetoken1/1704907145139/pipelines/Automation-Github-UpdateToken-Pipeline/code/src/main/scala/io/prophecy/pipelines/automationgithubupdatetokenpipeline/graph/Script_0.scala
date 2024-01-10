package io.prophecy.pipelines.automationgithubupdatetokenpipeline.graph

import io.prophecy.libs._
import io.prophecy.pipelines.automationgithubupdatetokenpipeline.config.Context
import io.prophecy.pipelines.automationgithubupdatetokenpipeline.udfs.UDFs._
import io.prophecy.pipelines.automationgithubupdatetokenpipeline.udfs._
import io.prophecy.pipelines.automationgithubupdatetokenpipeline.udfs.PipelineInitCode._
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
