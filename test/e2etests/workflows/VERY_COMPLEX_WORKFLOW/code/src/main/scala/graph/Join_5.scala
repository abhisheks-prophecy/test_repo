package graph

import io.prophecy.libs._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import config.ConfigStore._
import udfs.UDFs._
import udfs._

object Join_5 {

  def apply(spark: SparkSession, in0: DataFrame, in1: DataFrame): DataFrame =
    in0
      .as("in0")
      .join(
        in1.as("in1"),
        col("in0.cmls_3ds_authntn_mthd") === col("in1.cmls_3ds_authntn_mthd"),
        "inner"
      )
      .select(
        col("in0.cmls_3ds_authntn_mthd").as("cmls_3ds_authntn_mthd"),
        col("in0.cmls_acct_cobrnd_bus_id_drvd")
          .as("cmls_acct_cobrnd_bus_id_drvd"),
        col("in1.cmls_acct_usage_cd").as("cmls_acct_usage_cd"),
        col("in1.cmls_acct_usr_bus_id_ctry_cd_drvd")
          .as("cmls_acct_usr_bus_id_ctry_cd_drvd")
      )

}
