from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from py_del_git_pipeline1.config.ConfigStore import *
from py_del_git_pipeline1.udfs.UDFs import *

def src_json_input_custs_0(spark: SparkSession) -> DataFrame:
    return spark.read\
        .format("json")\
        .schema(
          StructType([
            StructField("account_flags", StringType(), True), StructField("account_open_date", StringType(), True), StructField("country_code", StringType(), True), StructField("customer_id", StringType(), True), StructField("email", StringType(), True), StructField("first_name", StringType(), True), StructField("last_name", StringType(), True), StructField("phone", StringType(), True)
        ])
        )\
        .load("dbfs:/Prophecy/qa_data/json/CustomersDatasetInput.json")
