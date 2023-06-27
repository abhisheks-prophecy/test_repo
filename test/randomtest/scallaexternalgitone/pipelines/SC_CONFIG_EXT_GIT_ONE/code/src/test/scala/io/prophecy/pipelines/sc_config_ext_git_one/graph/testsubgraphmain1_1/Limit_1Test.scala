package io.prophecy.pipelines.sc_config_ext_git_one.graph.testsubgraphmain1_1

import com.holdenkarau.spark.testing.DataFrameSuiteBase
import io.prophecy.pipelines.sc_config_ext_git_one.config._
import io.prophecy.libs.registerAllUDFs
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
class Limit_1Test extends FunSuite with DataFrameSuiteBase {
  import sqlContext.implicits._
  var context: Context = null

  test("Unit Test 0") {

    val dfIn = createDfFromResourceFiles(
      spark,
      "/data/io/prophecy/pipelines/sc_config_ext_git_one/graph/testsubgraphmain1_1/Limit_1/in/schema.json",
      "/data/io/prophecy/pipelines/sc_config_ext_git_one/graph/testsubgraphmain1_1/Limit_1/in/data/unit_test_0.json",
      "in"
    )
    val dfOut = createDfFromResourceFiles(
      spark,
      "/data/io/prophecy/pipelines/sc_config_ext_git_one/graph/testsubgraphmain1_1/Limit_1/out/schema.json",
      "/data/io/prophecy/pipelines/sc_config_ext_git_one/graph/testsubgraphmain1_1/Limit_1/out/data/unit_test_0.json",
      "out"
    )

    val dfOutComputed =
      io.prophecy.pipelines.sc_config_ext_git_one.graph.testsubgraphmain1_1
        .Limit_1(
          io.prophecy.pipelines.sc_config_ext_git_one.graph.testsubgraphmain1_1.config
            .Context(context.spark, context.config.testsubgraphmain1_1),
          dfIn
        )
    val res = assertDFEquals(
      dfOut.select("c   short  --",
                   "c-int-column type",
                   "-- c-long",
                   "c-decimal",
                   "c  float",
                   "c--boolean",
                   "c- - -double",
                   "c___-- string",
                   "c  date",
                   "c_timestamp"
      ),
      dfOutComputed.select("c   short  --",
                           "c-int-column type",
                           "-- c-long",
                           "c-decimal",
                           "c  float",
                           "c--boolean",
                           "c- - -double",
                           "c___-- string",
                           "c  date",
                           "c_timestamp"
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
    registerAllUDFs(spark)

    val fabricName = System.getProperty("fabric")

    val config = ConfigurationFactoryImpl.fromCLI(
      Array("--confFile",
            getClass.getResource(s"/config/${fabricName}.json").getPath
      )
    )

    context = Context(spark, config)

    val dfProphecy_pipelines_sc_config_ext_git_one_graph_Lookup_1 =
      createDfFromResourceFiles(
        spark,
        "/data/io/prophecy/pipelines/sc_config_ext_git_one/graph/Lookup_1/schema.json",
        "/data/io/prophecy/pipelines/sc_config_ext_git_one/graph/Lookup_1/data.json",
        port = "in"
      )
    io.prophecy.pipelines.sc_config_ext_git_one.graph.Lookup_1(
      context,
      dfProphecy_pipelines_sc_config_ext_git_one_graph_Lookup_1
    )
  }

}
