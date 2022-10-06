package io.prophecy.pipelines.scala_external_git_pipeline.graph

import io.prophecy.libs._
import io.prophecy.pipelines.scala_external_git_pipeline.config.ConfigStore._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object src_avro {

  def apply(spark: SparkSession): DataFrame = {
    import org.apache.avro.Schema
    var reader = spark.read.format("avro")
    reader = reader
    reader.load("dbfs:/Prophecy/qa_data/avro/CustomersDatasetInput.avro")
  }

}
