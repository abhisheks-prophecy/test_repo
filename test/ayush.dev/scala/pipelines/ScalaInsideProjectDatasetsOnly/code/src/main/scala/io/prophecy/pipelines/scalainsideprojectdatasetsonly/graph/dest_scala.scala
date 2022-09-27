package io.prophecy.pipelines.scalainsideprojectdatasetsonly.graph

import io.prophecy.libs._
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.config.ConfigStore._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object dest_scala {

  def apply(spark: SparkSession, in: DataFrame): Unit =
    in.write
      .format("parquet")
      .mode("overwrite")
      .save("dbfs:/tmp/e2e/projectiddecoupling/dest_scala")

}
