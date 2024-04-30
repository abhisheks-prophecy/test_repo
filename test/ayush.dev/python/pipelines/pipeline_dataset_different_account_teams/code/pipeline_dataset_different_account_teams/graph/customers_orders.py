from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from pipeline_dataset_different_account_teams.config.ConfigStore import *
from pipeline_dataset_different_account_teams.udfs.UDFs import *

def customers_orders(spark: SparkSession) -> DataFrame:
    return spark.read\
        .schema(
          StructType([
            StructField("customer_id", IntegerType(), True), StructField("orders", LongType(), False), StructField("amounts", DoubleType(), True), StructField("account_length_days", IntegerType(), True)
        ])
        )\
        .option("header", True)\
        .option("sep", ",")\
        .option("ignoreLeadingWhiteSpace", True)\
        .option("ignoreTrailingWhiteSpace", True)\
        .csv("dbfs:/Prophecy/abhisheks+e2etests@prophecy.io/CustomersOrders.csv")
