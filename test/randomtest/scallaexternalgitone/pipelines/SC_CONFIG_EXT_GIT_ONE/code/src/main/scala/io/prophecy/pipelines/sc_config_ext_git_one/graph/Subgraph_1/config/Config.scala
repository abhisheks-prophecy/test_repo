package io.prophecy.pipelines.sc_config_ext_git_one.graph.Subgraph_1.config

import io.prophecy.libs._
import pureconfig._
import pureconfig.generic.ProductHint
import org.apache.spark.sql.SparkSession

object Config {

  implicit val confHint: ProductHint[Config] =
    ProductHint[Config](ConfigFieldMapping(CamelCase, CamelCase))

}

case class Config(
  c_string: String = "stringhoonmain#@!%^&*2asda",
  c_int:    Int = -12312,
  c_float:  Float = 231.12312f,
  c_double: Double = 4.23423432412e11d,
  c_short:  Short = 123,
  c_databricks_secrets: DatabricksSecret =
    DatabricksSecret(scope = "qasecrets_mysql", key = "username"),
  c_spark_expression: String = "concat(`c  date`, `c  float`)",
  c_boolean:          Boolean = false,
  `c-ancient-config`: String = "arent i"
) extends ConfigBase

object DatabricksSecret {

  implicit val myIntReader: ConfigReader[DatabricksSecret] =
    ConfigReader[String].map { s =>
      val Array(scope, key) = s.split(":")
      DatabricksSecret(scope, key)
    }

}

case class DatabricksSecret(scope: String, key: String) {

  override def toString: String = {
    import com.databricks.dbutils_v1.DBUtilsHolder.dbutils
    dbutils.secrets.get(scope = scope, key = key)
  }

}

case class Context(spark: SparkSession, config: Config)
