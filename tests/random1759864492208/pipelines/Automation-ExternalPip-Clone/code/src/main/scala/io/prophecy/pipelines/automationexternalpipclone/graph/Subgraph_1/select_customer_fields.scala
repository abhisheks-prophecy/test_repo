package io.prophecy.pipelines.automationexternalpipclone.graph.Subgraph_1

import io.prophecy.libs._
import io.prophecy.pipelines.automationexternalpipclone.functions.PipelineInitCode._
import io.prophecy.pipelines.automationexternalpipclone.functions.UDFs._
import io.prophecy.pipelines.automationexternalpipclone.graph.Subgraph_1.config.Context
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object select_customer_fields {

  def apply(context: Context, in: DataFrame): DataFrame =
    in.select(col("customer_id"),
              col("first_name"),
              col("last_name"),
              col("phone"),
              col("email"),
              col("country_code"),
              col("account_open_date"),
              col("account_flags")
    )

}
