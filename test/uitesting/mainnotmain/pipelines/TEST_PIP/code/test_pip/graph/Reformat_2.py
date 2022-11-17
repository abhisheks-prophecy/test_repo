from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from test_pip.config.ConfigStore import *
from test_pip.udfs.UDFs import *

def Reformat_2(spark: SparkSession, in0: DataFrame) -> DataFrame:
    return in0.select(
        col("customer_id"), 
        col("first_name"), 
        col("last_name"), 
        col("phone"), 
        col("email"), 
        col("country_code"), 
        col("account_open_date"), 
        col("account_flags")
    )
