package io.prophecy.pipelines.workflowautomatedrollback1686620117494.udfs

import _root_.io.prophecy.abinitio.ScalaFunctions._
import _root_.io.prophecy.libs._
import org.apache.spark.sql.types._
import org.apache.spark.sql.functions._
import org.apache.spark.sql._

object UDFs extends Serializable {

  def registerUDFs(spark: SparkSession) =
    registerAllUDFs(spark)

}

object PipelineInitCode extends Serializable
