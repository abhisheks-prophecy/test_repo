package io.prophecy.pipelines.automationexternalpipclone.config

import pureconfig._
import pureconfig.generic.ProductHint
import io.prophecy.libs._
import io.prophecy.pipelines.automationexternalpipclone.graph.Subgraph_1.config.{
  Config => Subgraph_1_Config
}

case class Config(var Subgraph_1: Subgraph_1_Config = Subgraph_1_Config())
    extends ConfigBase
