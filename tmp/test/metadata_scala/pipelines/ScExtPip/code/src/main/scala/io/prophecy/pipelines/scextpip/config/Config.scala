package io.prophecy.pipelines.scextpip.config

import io.prophecy.pipelines.scextpip.config.ConfigStore._
import pureconfig._
import io.prophecy.libs._
case class Config(c_string: String = "ttest") extends ConfigBase
