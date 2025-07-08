package io.prophecy.pipelines.automationchetanexternalpipclone.config

import org.apache.spark.sql.SparkSession
case class Context(spark: SparkSession, config: Config)
