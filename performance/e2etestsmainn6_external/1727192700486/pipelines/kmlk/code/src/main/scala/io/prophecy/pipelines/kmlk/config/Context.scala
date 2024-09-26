package io.prophecy.pipelines.kmlk.config

import org.apache.spark.sql.SparkSession
case class Context(spark: SparkSession, config: Config)
