from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from pyprepipeline.config.ConfigStore import *
from pyprepipeline.udfs.UDFs import *

def src_warehouse(spark: SparkSession) -> DataFrame:
    from pyspark.dbutils import DBUtils

    return spark.read\
        .format("jdbc")\
        .option("url", "jdbc:mysql://18.144.156.219:3306/test_database")\
        .option("user", DBUtils(spark).secrets.get(scope = "qasecrets_mysql", key = "username"))\
        .option("password", DBUtils(spark).secrets.get(scope = "qasecrets_mysql", key = "password"))\
        .option("dbtable", "test_table")\
        .option("pushDownPredicate", True)\
        .option("driver", "com.mysql.jdbc.Driver")\
        .load()
