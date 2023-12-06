package abhishekse2etestsprophecy.io_team.scalaexternalgitone

import org.apache.spark.sql._
package object functions {
  val int_udf = Int_udf.int_udf

  def registerFunctions(spark: SparkSession) =
    spark.udf.register("int_udf", int_udf)

}
