from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from pythonlivy.config.ConfigStore import *
from pythonlivy.udfs.UDFs import *

def Join_1(spark: SparkSession, in0: DataFrame, in1: DataFrame, ) -> DataFrame:
    return in0\
        .alias("in0")\
        .join(in1.alias("in1"), (col("in0.industry_code_ANZSIC") == col("in1.industry_code_ANZSIC")), "inner")\
        .select(col("in0.year").alias("year"), col("in0.industry_code_ANZSIC").alias("industry_code_ANZSIC"), col("in0.industry_name_ANZSIC").alias("industry_name_ANZSIC"), col("in0.rme_size_grp").alias("rme_size_grp"), col("in0.variable").alias("variable"), col("in0.value").alias("value"), col("in1.unit").alias("unit"))
