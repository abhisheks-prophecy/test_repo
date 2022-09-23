from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from pipeline_dataset_different_account_teams.config.ConfigStore import *
from pipeline_dataset_different_account_teams.udfs.UDFs import *

def Reformat_2(spark: SparkSession, in0: DataFrame) -> DataFrame:
    return in0.select(col("customer_id"), col("orders"), col("amounts"), col("account_length_days"))
