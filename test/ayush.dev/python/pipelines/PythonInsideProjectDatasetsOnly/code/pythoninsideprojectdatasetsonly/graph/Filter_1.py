from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from pythoninsideprojectdatasetsonly.config.ConfigStore import *
from pythoninsideprojectdatasetsonly.udfs.UDFs import *

def Filter_1(spark: SparkSession, in0: DataFrame) -> DataFrame:
    return in0.filter(lit(True))
