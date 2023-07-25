package io.prophecy.pipelines.scalainsideprojectdatasetsonly.graph

import io.prophecy.libs._
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.config.Context
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object src_delta {

  def apply(context: Context): DataFrame =
    context.spark.read
      .format("delta")
      .load("dbfs:/Prophecy/qa_data/delta/all_type_and_partition")

}
