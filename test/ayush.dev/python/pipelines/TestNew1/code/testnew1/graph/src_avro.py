from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from testnew1.config.ConfigStore import *
from testnew1.udfs.UDFs import *

def src_avro(spark: SparkSession) -> DataFrame:
    return spark.read.format("avro").load("dbfs:/Prophecy/qa_data/avro/CustomersDatasetInput.avro")
