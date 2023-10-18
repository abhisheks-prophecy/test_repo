package io.prophecy.pipelines.sc_config_ext_git_one.graph

import com.holdenkarau.spark.testing.DataFrameSuiteBase
import io.prophecy.pipelines.sc_config_ext_git_one.config._
import io.prophecy.libs.SparkTestingUtils._
import org.apache.spark.sql.types._
import org.apache.spark.sql.{Column, DataFrame}
import org.apache.spark.sql.functions._
import org.junit.runner.RunWith
import org.junit.Assert
import org.scalatest.FunSuite
import java.time.LocalDateTime
import org.scalatest.junit.JUnitRunner
import java.sql.{Date, Timestamp}
import scala.collection.JavaConverters._
import java.nio.file.{Files, Paths}
import java.math.BigDecimal

@RunWith(classOf[JUnitRunner])
class Reformat_1Test extends FunSuite with DataFrameSuiteBase {
  import sqlContext.implicits._

  test("Unit Test 0") {

    val dfIn = createDfFromResourceFiles(
      spark,
      "/data/io/prophecy/pipelines/sc_config_ext_git_one/graph/Reformat_1/in/schema.json",
      "/data/io/prophecy/pipelines/sc_config_ext_git_one/graph/Reformat_1/in/data/unit_test_0.json",
      "in"
    )
    val dfOut = createDfFromResourceFiles(
      spark,
      "/data/io/prophecy/pipelines/sc_config_ext_git_one/graph/Reformat_1/out/schema.json",
      "/data/io/prophecy/pipelines/sc_config_ext_git_one/graph/Reformat_1/out/data/unit_test_0.json",
      "out"
    )

    val dfOutComputed =
      io.prophecy.pipelines.sc_config_ext_git_one.graph.Reformat_1(spark, dfIn)
    val res = assertDFEquals(
      dfOut.select("c_config_str",
                   "c_config_bool",
                   "c_config_int",
                   "c_config_float",
                   "c_config_double",
                   "c_config_sparkexpression",
                   "c_lookup",
                   "c_udf1"
      ),
      dfOutComputed.select("c_config_str",
                           "c_config_bool",
                           "c_config_int",
                           "c_config_float",
                           "c_config_double",
                           "c_config_sparkexpression",
                           "c_lookup",
                           "c_udf1"
      ),
      maxUnequalRowsToShow,
      1.0
    )
    val msg = if (res.isLeft) res.left.get.getMessage else ""
    Assert.assertTrue(msg, res.isRight)
  }

  override def beforeAll() = {
    super.beforeAll()
    spark.conf.set("spark.sql.legacy.allowUntypedScalaUDF", "true")

    val fabricName = System.getProperty("fabric")

    ConfigStore.Config = ConfigurationFactoryImpl.fromCLI(
      Array("--confFile",
            getClass.getResource(s"/config/${fabricName}.json").getPath
      )
    )

    val dfProphecy_pipelines_sc_config_ext_git_one_graph_Lookup_1 =
      createDfFromResourceFiles(
        spark,
        "/data/io/prophecy/pipelines/sc_config_ext_git_one/graph/Lookup_1/schema.json",
        "/data/io/prophecy/pipelines/sc_config_ext_git_one/graph/Lookup_1/data.json",
        port = "in"
      )
    io.prophecy.pipelines.sc_config_ext_git_one.graph.Lookup_1(
      spark,
      dfProphecy_pipelines_sc_config_ext_git_one_graph_Lookup_1
    )
  }

}