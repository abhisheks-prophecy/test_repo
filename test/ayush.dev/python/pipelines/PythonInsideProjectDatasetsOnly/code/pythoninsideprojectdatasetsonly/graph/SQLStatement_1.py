from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from pythoninsideprojectdatasetsonly.config.ConfigStore import *
from pythoninsideprojectdatasetsonly.udfs.UDFs import *

def SQLStatement_1(spark: SparkSession, in0: DataFrame) -> (DataFrame):
    in0.createOrReplaceTempView("in0")
    df1 = spark.sql("select c_tinyint,c_int,c_boolean from in0 where c_tinyint > 0")

    return df1
