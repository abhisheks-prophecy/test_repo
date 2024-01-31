from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from python_external_git_pipeline.config.ConfigStore import *
from python_external_git_pipeline.udfs.UDFs import *

def Reformat_4(spark: SparkSession, in0: DataFrame) -> DataFrame:
    return in0.select(col("customer_id"), col("orders"), col("amounts"), col("account_length_days"))
