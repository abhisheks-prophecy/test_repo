from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from python_external_git_pipeline.config.ConfigStore import *
from python_external_git_pipeline.udfs.UDFs import *

def customers(spark: SparkSession) -> DataFrame:
    return spark.read\
        .schema(
          StructType([
            StructField("customer_id", IntegerType(), True), StructField("first_name", StringType(), True), StructField("last_name", StringType(), True), StructField("phone", StringType(), True), StructField("email", StringType(), True), StructField("country_code", StringType(), True), StructField("account_open_date", StringType(), True), StructField("account_flags", StringType(), True)
        ])
        )\
        .option("header", True)\
        .option("sep", ",")\
        .option("ignoreLeadingWhiteSpace", True)\
        .option("ignoreTrailingWhiteSpace", True)\
        .csv("dbfs:/Prophecy/abhisheks+e2etests@prophecy.io/CustomersDatasetInput.csv")
