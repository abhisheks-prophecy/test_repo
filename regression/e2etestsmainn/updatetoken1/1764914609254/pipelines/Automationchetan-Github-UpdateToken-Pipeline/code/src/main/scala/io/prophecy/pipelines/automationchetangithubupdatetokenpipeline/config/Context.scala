package io.prophecy.pipelines.automationchetangithubupdatetokenpipeline.config

import org.apache.spark.sql.SparkSession
case class Context(spark: SparkSession, config: Config)
