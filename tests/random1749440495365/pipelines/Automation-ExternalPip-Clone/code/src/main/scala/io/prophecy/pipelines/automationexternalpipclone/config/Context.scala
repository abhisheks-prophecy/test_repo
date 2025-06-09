package io.prophecy.pipelines.automationexternalpipclone.config

import org.apache.spark.sql.SparkSession
case class Context(spark: SparkSession, config: Config)
