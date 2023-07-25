package io.prophecy.pipelines.scalainsideprojectdatasetsonly.graph.Subgraph_1.Subgraph_2.config

import io.prophecy.libs._
import pureconfig._
import pureconfig.generic.ProductHint
import org.apache.spark.sql.SparkSession
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.graph.Subgraph_1.Subgraph_2.Subgraph_3.config.{
  Config => Subgraph_3_Config
}

object Config {

  implicit val confHint: ProductHint[Config] =
    ProductHint[Config](ConfigFieldMapping(CamelCase, CamelCase))

}

case class Config(
  c_config_str:     String = "test value",
  c_config_boolean: Boolean = true,
  c_config_float:   Float = 10.2f,
  c_config_int:     Int = 12,
  Subgraph_3:       Subgraph_3_Config = Subgraph_3_Config()
) extends ConfigBase

case class Context(spark: SparkSession, config: Config)
