package io.prophecy.pipelines.scala_external_git_pipeline.config

import io.prophecy.pipelines.scala_external_git_pipeline.config.ConfigStore._
import pureconfig._
import io.prophecy.libs._
case class Config(c_string: String = "value") extends ConfigBase
