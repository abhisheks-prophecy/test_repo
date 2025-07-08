package io.prophecy.pipelines.automationchetanexternalpipclone.graph

import io.prophecy.libs._
import io.prophecy.pipelines.automationchetanexternalpipclone.functions.PipelineInitCode._
import io.prophecy.pipelines.automationchetanexternalpipclone.functions.UDFs._
import io.prophecy.pipelines.automationchetanexternalpipclone.config.Context
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object order_by_full_name {

  def apply(context: Context, in: DataFrame): DataFrame =
    in.orderBy(concat(col("first_name"), col("last_name")).asc_nulls_last)

}
