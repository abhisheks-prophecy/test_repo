package io.prophecy.pipelines.automation_rollbackchanges_pipeline2.config

import org.apache.spark.sql.SparkSession
case class Context(spark: SparkSession, config: Config)
