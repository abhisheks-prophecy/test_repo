package io.prophecy.pipelines.scala_external_git_pipeline.graph

import io.prophecy.libs._
import io.prophecy.pipelines.scala_external_git_pipeline.config.ConfigStore._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object src_jdbc {

  def apply(spark: SparkSession): DataFrame = {
    import com.databricks.dbutils_v1.DBUtilsHolder.dbutils
    var reader = spark.read
      .format("jdbc")
      .option("url", "jdbc:mysql://18.144.156.219:3306/test_database")
      .option("user",
              dbutils.secrets.get(scope = "qasecrets_mysql", key = "username")
      )
      .option("password",
              dbutils.secrets.get(scope = "qasecrets_mysql", key = "password")
      )
      .option("dbtable", "test_table")
    reader = reader
      .option("pushDownPredicate", true)
      .option("driver",            "com.mysql.jdbc.Driver")
    reader.load()
  }

}
