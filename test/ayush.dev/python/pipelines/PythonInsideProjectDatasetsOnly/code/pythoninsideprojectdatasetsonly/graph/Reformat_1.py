from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from pythoninsideprojectdatasetsonly.config.ConfigStore import *
from pythoninsideprojectdatasetsonly.udfs.UDFs import *

def Reformat_1(spark: SparkSession, in0: DataFrame) -> DataFrame:
    return in0.select(
        col("customer_id"), 
        col("first_name"), 
        col("last_name"), 
        col("phone"), 
        col("email"), 
        col("country_code"), 
        col("account_open_date"), 
        col("account_flags"), 
        lookup("LookupMain", col("customer_id"), col("email")).getField("first_name").alias("c_lookup"), 
        concat(lit(Config.c_string), col("first_name"), squared(col("customer_id").cast(IntegerType())))\
          .alias("c_config")
    )
