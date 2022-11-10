from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from pythoninsideprojectdatasetsonly.config.ConfigStore import *
from pythoninsideprojectdatasetsonly.udfs.UDFs import *

def RowDistributor_1(spark: SparkSession, in0: DataFrame) -> (DataFrame, DataFrame):
    df1 = in0.filter(col("c_boolean").eqNullSafe(lit(True)))
    df2 = in0.filter((col("c_boolean").eqNullSafe(lit(False)) & (col("c_int") == lit(767))))

    return df1, df2
