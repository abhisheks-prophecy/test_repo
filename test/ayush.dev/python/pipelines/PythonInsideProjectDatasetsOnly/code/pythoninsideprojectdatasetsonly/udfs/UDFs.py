from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from prophecy.lookups import (
    createLookup,
    createRangeLookup,
    lookup,
    lookup_last,
    lookup_match,
    lookup_count,
    lookup_row,
    lookup_row_reverse,
    lookup_nth
)
int_value = 10
float_value = 20

def registerUDFs(spark: SparkSession):
    spark.udf.register("squared", squared)

@udf(returnType = IntegerType())
def squared(value):
    return ((value * value) + int_value - float_value) if value else int_value
