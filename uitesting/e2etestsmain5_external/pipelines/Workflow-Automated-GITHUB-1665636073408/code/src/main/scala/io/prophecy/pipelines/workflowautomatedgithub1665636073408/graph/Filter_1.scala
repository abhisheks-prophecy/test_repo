package io.prophecy.pipelines.workflowautomatedgithub1665636073408.graph

import io.prophecy.libs._
import io.prophecy.pipelines.workflowautomatedgithub1665636073408.config.ConfigStore._
import io.prophecy.pipelines.workflowautomatedgithub1665636073408.udfs.UDFs._
import io.prophecy.pipelines.workflowautomatedgithub1665636073408.udfs._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object Filter_1 {

  def apply(spark: SparkSession, in: DataFrame): DataFrame =
    in.filter((col("customer_id") > lit(10)).and(col("first_name").like("%G%")))

}
