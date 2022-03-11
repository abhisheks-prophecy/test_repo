package graph

import io.prophecy.libs._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import config.ConfigStore._
import udfs.UDFs._
import udfs._

object Filter_1_1_1_1_1_1 {

  def apply(spark: SparkSession, in: DataFrame): DataFrame =
    in.filter(
      (col("cmls_acct_cobrnd_bus_id_drvd") > lit(0))
        .and(col("cmls_acct_fundg_srce_cd") =!= lit("D"))
    )

}
