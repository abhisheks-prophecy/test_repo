package io.prophecy.pipelines.scalainsideprojectdatasetsonly.graph.SG_SCALA_1.Subgraph_2.Subgraph_3

import io.prophecy.libs._
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.config.ConfigStore._
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.udfs.UDFs._
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.udfs._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object Filter_2 {

  def apply(spark: SparkSession, in: DataFrame): DataFrame =
    in.filter(lit(true))

}
