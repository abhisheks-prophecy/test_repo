package io.prophecy.pipelines.sc_config_ext_git_one.graph

import io.prophecy.libs._
import io.prophecy.pipelines.sc_config_ext_git_one.config.Context
import io.prophecy.pipelines.sc_config_ext_git_one.udfs.UDFs._
import io.prophecy.pipelines.sc_config_ext_git_one.udfs.PipelineInitCode._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object Lookup_1 {

  def apply(context: Context, in0: DataFrame): Unit =
    createLookup("TestLookup",
                 in0,
                 context.spark,
                 List("c_timestamp"),
                 "c-decimal"
    )

}
