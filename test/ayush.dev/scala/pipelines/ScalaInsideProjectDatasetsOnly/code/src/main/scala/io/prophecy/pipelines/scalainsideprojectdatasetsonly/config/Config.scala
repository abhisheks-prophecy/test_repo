package io.prophecy.pipelines.scalainsideprojectdatasetsonly.config

import io.prophecy.pipelines.scalainsideprojectdatasetsonly.config.ConfigStore._
import pureconfig._
import io.prophecy.libs._

case class Config(
  c_config_str:     String = "test value",
  c_config_boolean: Boolean = true,
  c_config_float:   Float = 10.2f,
  c_config_int:     Int = 12
) extends ConfigBase
