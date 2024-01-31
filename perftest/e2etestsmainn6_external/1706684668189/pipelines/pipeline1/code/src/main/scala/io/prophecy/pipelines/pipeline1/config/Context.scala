package io.prophecy.pipelines.pipeline1.config

import org.apache.spark.sql.SparkSession
case class Context(spark: SparkSession, config: Config)
