from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from pythoninsideprojectdatasetsonly.config.ConfigStore import *
from pythoninsideprojectdatasetsonly.udfs.UDFs import *

def Script_2(spark: SparkSession, in0: DataFrame) -> DataFrame:
    out0 = in0
    print("hello")

    return out0
