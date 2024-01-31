from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from testpipelinenonmain.config.ConfigStore import *
from testpipelinenonmain.udfs.UDFs import *

def testdataset(spark: SparkSession) -> DataFrame:
    return spark.read\
        .schema(StructType([StructField("a", StringType(), True)]))\
        .option("header", True)\
        .option("sep", ",")\
        .csv("dbfs:/tmp/e2e/test/randompath")
