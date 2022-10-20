from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from pyprepipeline.config.ConfigStore import *
from pyprepipeline.udfs.UDFs import *

def dest_warehouse(spark: SparkSession, in0: DataFrame):
    from pyspark.dbutils import DBUtils
    in0.write\
        .format("jdbc")\
        .option("url", "jdbc:mysql://18.144.156.219:3306/test_database")\
        .option("dbtable", "test_table_destination4")\
        .option("user", DBUtils(spark).secrets.get(scope = "qasecrets_mysql", key = "username"))\
        .option("user", DBUtils(spark).secrets.get(scope = "qasecrets_mysql", key = "username"))\
        .option("user", DBUtils(spark).secrets.get(scope = "qasecrets_mysql", key = "username"))\
        .option("password", DBUtils(spark).secrets.get(scope = "qasecrets_mysql", key = "password"))\
        .option("driver", "com.mysql.jdbc.Driver")\
        .mode("overwrite")\
        .save()
