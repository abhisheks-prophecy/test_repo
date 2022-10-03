from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from pyprepipeline.config.ConfigStore import *
from pyprepipeline.udfs.UDFs import *

def dest_csv(spark: SparkSession, in0: DataFrame):
    in0.write\
        .option("header", True)\
        .option("sep", ",")\
        .mode("overwrite")\
        .option("separator", ",")\
        .option("header", True)\
        .csv("dbfs:/tmp/e2e/gpd/dest_csv")
