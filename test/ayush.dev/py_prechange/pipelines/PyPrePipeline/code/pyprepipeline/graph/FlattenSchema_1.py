from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from pyprepipeline.config.ConfigStore import *
from pyprepipeline.udfs.UDFs import *

def FlattenSchema_1(spark: SparkSession, in0: DataFrame) -> DataFrame:
    return in0\
        .withColumn("c_array", explode_outer("c_array"))\
        .select(col("c_array"), col("c_struct"), col("c_struct.city").alias("c_struct-city"), col("c_double"))
