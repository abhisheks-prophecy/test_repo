from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from python_external_git_pipeline.config.ConfigStore import *
from python_external_git_pipeline.udfs.UDFs import *

def src_orc(spark: SparkSession) -> DataFrame:
    return spark.read.format("orc").load("dbfs:/Prophecy/qa_data/orc/all_type_and_partition")
