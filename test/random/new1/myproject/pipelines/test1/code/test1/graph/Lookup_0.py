from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from prophecy.libs import typed_lit
from test1.config.ConfigStore import *
from test1.udfs.UDFs import *

def Lookup_0(spark: SparkSession, in0: DataFrame):
    keyColumns = []
    valueColumns = []
    createLookup("", in0, spark, keyColumns, valueColumns)
