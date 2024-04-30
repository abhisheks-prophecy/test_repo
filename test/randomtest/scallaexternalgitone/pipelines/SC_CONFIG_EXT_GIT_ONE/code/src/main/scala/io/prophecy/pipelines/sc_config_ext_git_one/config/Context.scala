package io.prophecy.pipelines.sc_config_ext_git_one.config

import org.apache.spark.sql.SparkSession
case class Context(spark: SparkSession, config: Config)
