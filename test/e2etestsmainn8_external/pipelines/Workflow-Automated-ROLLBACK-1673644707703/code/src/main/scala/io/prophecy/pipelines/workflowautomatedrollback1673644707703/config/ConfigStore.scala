package io.prophecy.pipelines.workflowautomatedrollback1673644707703.config

import io.prophecy.pipelines.workflowautomatedrollback1673644707703.config.ConfigStore._
import io.prophecy.pipelines.workflowautomatedrollback1673644707703.config.Context
import pureconfig.ConfigReader.Result
import pureconfig._
import pureconfig.generic.ProductHint
import pureconfig.generic.auto._
import io.prophecy.libs._
object ConfigStore

object ConfigurationFactoryImpl extends ConfigurationFactory[Config] {

  override protected def load(
    fileConfig: ConfigObjectSource
  ): Result[Config] = {
    implicit val confHint: ProductHint[Config] =
      ProductHint[Config](ConfigFieldMapping(CamelCase, CamelCase))
    fileConfig.load[Config]
  }

}
