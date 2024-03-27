package io.prophecy.pipelines.automationexternalpipclone.graph

import io.prophecy.libs._
import io.prophecy.pipelines.automationexternalpipclone.udfs.PipelineInitCode._
import io.prophecy.pipelines.automationexternalpipclone.udfs.UDFs._
import io.prophecy.pipelines.automationexternalpipclone.config.Context
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object by_full_name_asc_nulls_last {

  def apply(context: Context, in: DataFrame): DataFrame =
    in.orderBy(concat(col("first_name"), col("last_name")).asc_nulls_last)

}
