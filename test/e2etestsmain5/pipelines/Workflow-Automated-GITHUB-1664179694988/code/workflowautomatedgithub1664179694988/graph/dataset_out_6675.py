from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from workflowautomatedgithub1664179694988.config.ConfigStore import *
from workflowautomatedgithub1664179694988.udfs.UDFs import *

def dataset_out_6675(spark: SparkSession, in0: DataFrame):
    in0.write\
        .option("header", True)\
        .option("sep", ",")\
        .mode("overwrite")\
        .option("separator", ",")\
        .option("header", True)\
        .csv("dbfs:/tmp/e2e/dataset_out_6675")
