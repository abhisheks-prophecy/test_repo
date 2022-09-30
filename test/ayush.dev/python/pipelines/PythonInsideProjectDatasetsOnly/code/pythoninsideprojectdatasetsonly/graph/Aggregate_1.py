from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from pythoninsideprojectdatasetsonly.config.ConfigStore import *
from pythoninsideprojectdatasetsonly.udfs.UDFs import *

def Aggregate_1(spark: SparkSession, in0: DataFrame) -> DataFrame:
    df1 = in0.groupBy(col("last_name"), col("firstname"))
    df2 = df1.pivot("c_concat", ["customer_id"])

    return df2.agg(
        first(col("account_flags")).alias("account_flags"), 
        first(col("account_open_date")).alias("account_open_date")
    )
