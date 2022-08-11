from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from job.config.ConfigStore import *
from job.udfs.UDFs import *

def Target_1(spark: SparkSession, in0: DataFrame):
    if Config.fabricName == "dev":
        in0.write\
            .option("header", True)\
            .option("sep", ",")\
            .mode("overwrite")\
            .option("separator", ",")\
            .option("header", True)\
            .csv("dbfs:/tmp/e2e/dataset_out_99755")
    else:
        raise Exception("No valid dataset present to read fabric")
