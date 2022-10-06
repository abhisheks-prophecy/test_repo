package io.prophecy.pipelines.scalainsideprojectdatasetsonly.udfs

import _root_.io.prophecy.abinitio.ScalaFunctions._
import _root_.io.prophecy.libs._
import org.apache.spark.sql.types._
import org.apache.spark.sql.functions._
import org.apache.spark.sql._

object UDFs extends Serializable {
  var int_val = 2

  def registerUDFs(spark: SparkSession) =
    spark.udf.register("intudf", intudf)

  def intudf = udf((value: Int) => value * value / int_val)
}
