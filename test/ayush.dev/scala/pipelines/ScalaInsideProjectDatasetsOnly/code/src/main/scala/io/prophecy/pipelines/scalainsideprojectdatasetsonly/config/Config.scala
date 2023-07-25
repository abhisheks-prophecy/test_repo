package io.prophecy.pipelines.scalainsideprojectdatasetsonly.config

import pureconfig._
import pureconfig.generic.ProductHint
import io.prophecy.libs._
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.graph.Subgraph_1.config.{
  Config => Subgraph_1_Config
}
import io.prophecy.pipelines.scalainsideprojectdatasetsonly.graph.SG_SCALA_1.config.{
  Config => SG_SCALA_1_Config
}

case class Config(
  c_config_str:     String = "test value",
  c_config_boolean: Boolean = true,
  c_config_float:   Float = 10.2f,
  c_config_int:     Int = 12,
  SG_SCALA_1:       SG_SCALA_1_Config = SG_SCALA_1_Config(),
  Subgraph_1:       Subgraph_1_Config = Subgraph_1_Config()
) extends ConfigBase
