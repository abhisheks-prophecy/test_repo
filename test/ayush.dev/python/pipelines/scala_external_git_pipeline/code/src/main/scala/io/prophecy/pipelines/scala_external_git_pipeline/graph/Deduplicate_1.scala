package io.prophecy.pipelines.scala_external_git_pipeline.graph

import io.prophecy.libs._
import io.prophecy.pipelines.scala_external_git_pipeline.config.ConfigStore._
import io.prophecy.pipelines.scala_external_git_pipeline.udfs.UDFs._
import io.prophecy.pipelines.scala_external_git_pipeline.udfs._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import java.time._

object Deduplicate_1 {

  def apply(spark: SparkSession, in: DataFrame): DataFrame = {
    import org.apache.spark.sql.expressions.Window
    in.dropDuplicates(List("c-int-column type", "-- c-long"))
  }

}
