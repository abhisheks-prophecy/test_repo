package io.prophecy.pipelines.workflowautomatedgithub1665763820711.config

import io.prophecy.pipelines.workflowautomatedgithub1665763820711.config.ConfigStore._
import pureconfig.ConfigReader.Result
import pureconfig._
import pureconfig.generic.ProductHint
import pureconfig.generic.auto._
import io.prophecy.libs._
object ConfigStore { implicit var Config: Config = _ }

object ConfigurationFactoryImpl extends ConfigurationFactory[Config] {

  override protected def load(
    fileConfig: ConfigObjectSource
  ): Result[Config] = {
    implicit val confHint: ProductHint[Config] =
      ProductHint[Config](ConfigFieldMapping(CamelCase, CamelCase))
    fileConfig.load[Config]
  }

}
