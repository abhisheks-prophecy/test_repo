from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from test_pip.config.ConfigStore import *
from test_pip.udfs.UDFs import *

def src_parquet(spark: SparkSession) -> DataFrame:
    return spark.read.format("parquet").load("dbfs:/Prophecy/qa_data/parquet/CustomersDatasetInput.parquet")
