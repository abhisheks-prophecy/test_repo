from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from pyprepipeline.config.ConfigStore import *
from pyprepipeline.udfs.UDFs import *

def Reformat_4(spark: SparkSession, in0: DataFrame) -> DataFrame:
    return in0.select(col("c_tinyint").alias("c_tinyint1"))
