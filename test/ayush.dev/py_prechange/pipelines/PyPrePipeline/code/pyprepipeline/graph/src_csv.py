from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from pyprepipeline.config.ConfigStore import *
from pyprepipeline.udfs.UDFs import *

def src_csv(spark: SparkSession) -> DataFrame:
    return spark.read\
        .schema(
          StructType([
            StructField("c   short  --", StringType(), True), StructField("c-int-column type", StringType(), True), StructField("-- c-long", StringType(), True), StructField("c-decimal", StringType(), True), StructField("c  float", StringType(), True), StructField("c--boolean", StringType(), True), StructField("c- - -double", StringType(), True), StructField("c___-- string", StringType(), True), StructField("c  date", StringType(), True), StructField("c_timestamp", StringType(), True)
        ])
        )\
        .option("header", True)\
        .option("sep", ",")\
        .csv("dbfs:/Prophecy/qa_data/csv/special_char_column_name")
