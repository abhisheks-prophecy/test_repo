package io.prophecy.pipelines.pipelineautomationgithub1720581887240.config

import io.prophecy.pipelines.pipelineautomationgithub1720581887240.config.Context
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

  def getConfig(args: Array[String]) =
    fromCLI(args)

}
