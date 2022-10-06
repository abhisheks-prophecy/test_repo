from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from python_external_git_pipeline.config.ConfigStore import *
from python_external_git_pipeline.udfs.UDFs import *

def FlattenSchema_1(spark: SparkSession, in0: DataFrame) -> DataFrame:
    return in0\
        .withColumn("c_array -- decimal", explode_outer("c_array -- decimal"))\
        .withColumn("c_array -- float", explode_outer("c_array -- float"))\
        .withColumn("c_struct -- _  -c_array_int - of a struct ", explode_outer("c_struct -- _  .c_array_int - of a struct "))\
        .select(col("c_array -- float"), col("c_array -- decimal"), col("c_struct -- _  .c_array_int - of a struct ").alias("c_struct -- _  -c_array_int - of a struct "), col("c_struct -- _  .c_timestamp - of a struct-").alias("c_struct -- _  -c_timestamp - of a struct-"))
