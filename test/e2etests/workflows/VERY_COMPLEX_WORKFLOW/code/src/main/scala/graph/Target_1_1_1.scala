package graph

import io.prophecy.libs._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import config.ConfigStore._

object Target_1_1_1 {

  def apply(spark: SparkSession, in: DataFrame): Unit = {
    Config.fabricName match {
      case "dev" =>
        in.write
          .format("parquet")
          .mode("overwrite")
          .save("dbfs:/tmp/e2e/parquet/otut2")
      case _ =>
        throw new Exception("No valid dataset present to read fabric")
    }
  }

}
