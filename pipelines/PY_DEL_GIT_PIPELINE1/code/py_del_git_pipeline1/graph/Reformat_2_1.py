from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from py_del_git_pipeline1.config.ConfigStore import *
from py_del_git_pipeline1.udfs.UDFs import *

def Reformat_2_1(spark: SparkSession, in0: DataFrame) -> DataFrame:
    return in0
