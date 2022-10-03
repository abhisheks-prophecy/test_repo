from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from workflowautomatedgithub1663348444512.config.ConfigStore import *
from workflowautomatedgithub1663348444512.udfs.UDFs import *

def dataset_out_47955(spark: SparkSession, in0: DataFrame):
    in0.write\
        .option("header", True)\
        .option("sep", ",")\
        .mode("overwrite")\
        .option("separator", ",")\
        .option("header", True)\
        .csv("dbfs:/tmp/e2e/dataset_out_47955")
