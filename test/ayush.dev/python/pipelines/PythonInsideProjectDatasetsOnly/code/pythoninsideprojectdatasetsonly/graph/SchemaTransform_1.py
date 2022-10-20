from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from pythoninsideprojectdatasetsonly.config.ConfigStore import *
from pythoninsideprojectdatasetsonly.udfs.UDFs import *

def SchemaTransform_1(spark: SparkSession, in0: DataFrame) -> DataFrame:
    return in0\
        .withColumn("c_concat", concat(col("account_flags"), col("account_open_date")))\
        .drop("country_code")\
        .withColumnRenamed("first_name", "firstname")
