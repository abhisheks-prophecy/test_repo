package abhishekse2etestsprophecy.io_team.scalaexternalgitone.functions

import _root_.io.prophecy.abinitio.ScalaFunctions._
import _root_.io.prophecy.libs._
import org.apache.spark.sql.types._
import org.apache.spark.sql.functions._
import org.apache.spark.sql._

object Int_udf extends Serializable {
  var int_val = 1
  def int_udf = udf((value: Int) => value * value * int_val)
}
