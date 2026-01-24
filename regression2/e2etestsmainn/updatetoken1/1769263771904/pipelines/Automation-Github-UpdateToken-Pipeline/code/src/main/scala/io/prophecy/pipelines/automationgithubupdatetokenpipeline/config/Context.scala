package io.prophecy.pipelines.automationgithubupdatetokenpipeline.config

import org.apache.spark.sql.SparkSession
case class Context(spark: SparkSession, config: Config)
