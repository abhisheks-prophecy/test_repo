package io.prophecy.pipelines.pipelineautomationchetan_release_api_1729668932395.graph

import io.prophecy.libs._
import io.prophecy.pipelines.pipelineautomationchetan_release_api_1729668932395.functions.PipelineInitCode._
import io.prophecy.pipelines.pipelineautomationchetan_release_api_1729668932395.functions.UDFs._
import io.prophecy.pipelines.pipelineautomationchetan_release_api_1729668932395.config.Context
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object customer_details_selection {

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
