package io.prophecy.pipelines.automation_rollbackchanges_pipeline1.config

import org.apache.spark.sql.SparkSession
case class Context(spark: SparkSession, config: Config)
