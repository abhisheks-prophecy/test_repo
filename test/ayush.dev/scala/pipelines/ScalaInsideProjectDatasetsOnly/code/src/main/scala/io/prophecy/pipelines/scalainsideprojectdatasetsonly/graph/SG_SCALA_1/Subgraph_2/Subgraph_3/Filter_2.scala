package io.prophecy.pipelines.scalainsideprojectdatasetsonly.graph.SG_SCALA_1.Subgraph_2.Subgraph_3

import io.prophecy.libs._
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.udfs.PipelineInitCode._
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.udfs.UDFs._
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.graph.SG_SCALA_1.Subgraph_2.Subgraph_3.config.Context
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object Filter_2 {
  def apply(context: Context, in: DataFrame): DataFrame = in.filter(lit(true))
}
