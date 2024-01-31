from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from pythonlivy.config.ConfigStore import *
from pythonlivy.udfs.UDFs import *

def Deduplicate_1(spark: SparkSession, in0: DataFrame) -> DataFrame:
    return in0.dropDuplicates(["unit"])
