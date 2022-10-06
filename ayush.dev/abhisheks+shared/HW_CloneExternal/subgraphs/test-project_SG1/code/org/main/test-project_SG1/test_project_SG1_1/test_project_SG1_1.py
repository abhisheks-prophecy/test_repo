from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from prophecy.utils import *
from . import *

def test_project_SG1_1(spark: SparkSession, in0: DataFrame, in1: DataFrame) -> DataFrame:
    df_By_CustomerId_1 = By_CustomerId_1(spark, in0, in1)
    df_Cleanup_1 = Cleanup_1(spark, df_By_CustomerId_1)
    df_Sum_Amounts_1 = Sum_Amounts_1(spark, df_Cleanup_1)

    return df_Sum_Amounts_1
