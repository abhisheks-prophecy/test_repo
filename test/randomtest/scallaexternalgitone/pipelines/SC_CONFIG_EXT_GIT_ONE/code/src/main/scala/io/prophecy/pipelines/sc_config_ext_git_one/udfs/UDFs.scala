package io.prophecy.pipelines.sc_config_ext_git_one.udfs

import _root_.io.prophecy.abinitio.ScalaFunctions._
import _root_.io.prophecy.libs._
import org.apache.spark.sql.types._
import org.apache.spark.sql.functions._
import org.apache.spark.sql._

object UDFs extends Serializable {

  def registerUDFs(spark: SparkSession) = {
    spark.udf.register("int_udf", int_udf)
    registerAllUDFs(spark)
  }

  def int_udf = {
    var int_val = 1
    udf((value: Int) => value * value * int_val)
  }

}

object PipelineInitCode extends Serializable { var int_val = 1 }
