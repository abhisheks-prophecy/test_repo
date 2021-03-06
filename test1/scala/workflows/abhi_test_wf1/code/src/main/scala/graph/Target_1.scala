package graph

import io.prophecy.libs._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import config.ConfigStore._

object Target_1 {

  def apply(spark: SparkSession, in: DataFrame): Unit = {
    Config.fabricName match {
      case "AbhishekSharedFabric" =>
        in.write
          .format("csv")
          .option("header", true)
          .option("sep",    ",")
          .mode("overwrite")
          .save("dbfs:/tmp/e2e/dataset_out_14814")
      case _ =>
        throw new Exception("No valid dataset present to read fabric")
    }
  }

}
