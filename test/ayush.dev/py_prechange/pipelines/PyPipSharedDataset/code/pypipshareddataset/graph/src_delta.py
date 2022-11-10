from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from pypipshareddataset.config.ConfigStore import *
from pypipshareddataset.udfs.UDFs import *

def src_delta(spark: SparkSession) -> DataFrame:
    return spark.read.format("delta").load("dbfs:/Prophecy/qa_data/delta/all_type_and_partition")
