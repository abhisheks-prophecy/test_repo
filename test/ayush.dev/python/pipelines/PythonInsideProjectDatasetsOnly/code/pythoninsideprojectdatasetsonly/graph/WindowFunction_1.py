from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from pythoninsideprojectdatasetsonly.config.ConfigStore import *
from pythoninsideprojectdatasetsonly.udfs.UDFs import *

def WindowFunction_1(spark: SparkSession, in0: DataFrame) -> DataFrame:
    return in0\
        .withColumn(
          "customer_id_account_flags",
          row_number()\
            .over(Window.partitionBy(col("last_name"), col("firstname")).orderBy(col("customer_id_account_flags").asc()))
        )\
        .withColumn("customer_id_account_open_date", row_number()\
        .over(Window.partitionBy(col("last_name"), col("firstname")).orderBy(col("customer_id_account_flags").asc())))
