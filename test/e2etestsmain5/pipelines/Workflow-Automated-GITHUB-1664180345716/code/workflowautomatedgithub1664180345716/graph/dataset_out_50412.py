from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from workflowautomatedgithub1664180345716.config.ConfigStore import *
from workflowautomatedgithub1664180345716.udfs.UDFs import *

def dataset_out_50412(spark: SparkSession, in0: DataFrame):
    in0.write\
        .option("header", True)\
        .option("sep", ",")\
        .mode("overwrite")\
        .option("separator", ",")\
        .option("header", True)\
        .csv("dbfs:/tmp/e2e/dataset_out_50412")
