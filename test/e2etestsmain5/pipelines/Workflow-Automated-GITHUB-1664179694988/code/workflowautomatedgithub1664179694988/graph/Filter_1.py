from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from workflowautomatedgithub1664179694988.config.ConfigStore import *
from workflowautomatedgithub1664179694988.udfs.UDFs import *

def Filter_1(spark: SparkSession, in0: DataFrame) -> DataFrame:
    return in0.filter(((col("customer_id") > lit(10)) & col("first_name").like("%G%")))
