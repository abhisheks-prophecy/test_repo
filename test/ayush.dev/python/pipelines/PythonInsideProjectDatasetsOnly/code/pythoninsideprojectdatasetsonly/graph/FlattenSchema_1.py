from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from pythoninsideprojectdatasetsonly.config.ConfigStore import *
from pythoninsideprojectdatasetsonly.udfs.UDFs import *

def FlattenSchema_1(spark: SparkSession, in0: DataFrame) -> DataFrame:
    return in0\
        .withColumn("c_array_decimal", explode_outer("c_array_decimal"))\
        .withColumn("c_array_float", explode_outer("c_array_float"))\
        .withColumn("c_struct-c_array_int", explode_outer("c_struct.c_array_int"))\
        .select(col("c_array_float"), col("c_array_decimal"), col("c_struct.c_array_int").alias("c_struct-c_array_int"))
