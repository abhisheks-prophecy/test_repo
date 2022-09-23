from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from python_external_git_pipeline.config.ConfigStore import *
from python_external_git_pipeline.udfs.UDFs import *

def Reformat_1(spark: SparkSession, in0: DataFrame) -> DataFrame:
    return in0.select(
        col("c_tinyint"), 
        col("c_smallint"), 
        col("c_int"), 
        col("c_bigint"), 
        col("c_float"), 
        col("c_double"), 
        col("c_string"), 
        col("c_boolean"), 
        col("c_array"), 
        col("c_struct"), 
        concat(lit(Config.c_config1), col("c_smallint"), squared(col("c_int"))).alias("c1")
    )
