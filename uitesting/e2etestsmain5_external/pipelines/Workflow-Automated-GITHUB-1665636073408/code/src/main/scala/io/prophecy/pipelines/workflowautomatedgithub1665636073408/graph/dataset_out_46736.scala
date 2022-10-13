package io.prophecy.pipelines.workflowautomatedgithub1665636073408.graph

import io.prophecy.libs._
import io.prophecy.pipelines.workflowautomatedgithub1665636073408.config.ConfigStore._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object dataset_out_46736 {

  def apply(spark: SparkSession, in: DataFrame): Unit =
    in.write
      .format("csv")
      .option("header", true)
      .option("sep",    ",")
      .mode("overwrite")
      .save("dbfs:/tmp/e2e/dataset_out_46736")

}
