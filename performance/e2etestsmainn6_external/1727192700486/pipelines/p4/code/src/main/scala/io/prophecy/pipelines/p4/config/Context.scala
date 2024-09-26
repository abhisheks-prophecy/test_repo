package io.prophecy.pipelines.p4.config

import org.apache.spark.sql.SparkSession
case class Context(spark: SparkSession, config: Config)
