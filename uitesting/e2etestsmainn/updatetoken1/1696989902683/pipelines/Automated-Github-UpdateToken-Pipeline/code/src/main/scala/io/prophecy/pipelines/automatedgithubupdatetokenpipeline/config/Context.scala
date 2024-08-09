package io.prophecy.pipelines.automatedgithubupdatetokenpipeline.config

import org.apache.spark.sql.SparkSession
case class Context(spark: SparkSession, config: Config)
