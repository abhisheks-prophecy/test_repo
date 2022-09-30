from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from pythoninsideprojectdatasetsonly.config.ConfigStore import *
from pythoninsideprojectdatasetsonly.udfs.UDFs import *

def Join_1(spark: SparkSession, in0: DataFrame, in1: DataFrame, ) -> DataFrame:
    return in0\
        .alias("in0")\
        .join(in1.alias("in1"), (col("in0.c_tinyint") == col("in1.c_tinyint")), "inner")\
        .select(col("in0.c_tinyint").alias("c_tinyint"), col("in0.c_int").alias("c_int"), col("in0.c_boolean").alias("c_boolean"))
