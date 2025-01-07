package io.prophecy.pipelines.sc_config_ext_git_one.config

import pureconfig._
import pureconfig.generic.ProductHint
import io.prophecy.libs._
import io.prophecy.pipelines.sc_config_ext_git_one.graph.Subgraph_1.config.{
  Config => Subgraph_1_Config
}
import io.prophecy.pipelines.sc_config_ext_git_one.graph.testsubgraphmain1_1.config.{
  Config => testsubgraphmain1_1_Config
}

case class Config(
  c_string: String = "stringhoonmain#@!%^&*2asda",
  c_int:    Int = -12312,
  c_float:  Float = 231.12312f,
  c_double: Double = 4.23423432412e11d,
  c_short:  Short = 123,
  c_databricks_secrets: SecretValue = SecretValue(
    providerType = Some("Databricks"),
    secretScope = Some("qasecrets_mysql"),
    secretKey = Some("username")
  ),
  c_spark_expression:  String = "concat(`c  date`, `c  float`)",
  c_boolean:           Boolean = false,
  `c-ancient-config`:  String = "arent i",
  Subgraph_1:          Subgraph_1_Config = Subgraph_1_Config(),
  testsubgraphmain1_1: testsubgraphmain1_1_Config = testsubgraphmain1_1_Config()
) extends ConfigBase
