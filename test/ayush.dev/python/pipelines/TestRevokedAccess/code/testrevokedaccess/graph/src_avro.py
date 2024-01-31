from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from testrevokedaccess.config.ConfigStore import *
from testrevokedaccess.udfs.UDFs import *

def src_avro(spark: SparkSession) -> DataFrame:
    return spark.read.format("avro").load("dbfs:/Prophecy/qa_data/avro/CustomersDatasetInput.avro")
