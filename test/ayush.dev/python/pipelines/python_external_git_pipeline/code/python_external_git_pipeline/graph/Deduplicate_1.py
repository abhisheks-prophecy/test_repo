from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from python_external_git_pipeline.config.ConfigStore import *
from python_external_git_pipeline.udfs.UDFs import *

def Deduplicate_1(spark: SparkSession, in0: DataFrame) -> DataFrame:
    return in0.dropDuplicates(["c_long", "c_timestamp"])
