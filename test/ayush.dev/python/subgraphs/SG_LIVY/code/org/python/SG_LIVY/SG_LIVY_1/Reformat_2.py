from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from pythonlivy.config.ConfigStore import *
from pythonlivy.udfs.UDFs import *

def Reformat_2(spark: SparkSession, in0: DataFrame) -> DataFrame:
    return in0
