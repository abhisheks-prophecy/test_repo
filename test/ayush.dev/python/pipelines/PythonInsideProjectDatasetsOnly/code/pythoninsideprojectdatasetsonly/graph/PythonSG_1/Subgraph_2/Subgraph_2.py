from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from prophecy.utils import *
from . import *

def Subgraph_2(spark: SparkSession, in0: DataFrame) -> DataFrame:
    df_Reformat_3 = Reformat_3(spark, in0)
    df_Subgraph_3 = Subgraph_3(spark, df_Reformat_3)

    return df_Subgraph_3
