package io.prophecy.pipelines.sc_config_ext_git_one.graph

import io.prophecy.libs._
import io.prophecy.pipelines.sc_config_ext_git_one.config.ConfigStore._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object customers_orders {

  def apply(spark: SparkSession): DataFrame =
    spark.read
      .format("csv")
      .option("header",                   true)
      .option("sep",                      ",")
      .option("ignoreLeadingWhiteSpace",  false)
      .option("ignoreTrailingWhiteSpace", false)
      .schema(
        StructType(
          Array(
            StructField("customer_id",         IntegerType, true),
            StructField("orders",              LongType,    false),
            StructField("amounts",             DoubleType,  true),
            StructField("account_length_days", IntegerType, true)
          )
        )
      )
      .load(
        "dbfs:/Prophecy/abhisheks+e2etests1@simpledatalabs.com/CustomersOrders.csv"
      )

}
