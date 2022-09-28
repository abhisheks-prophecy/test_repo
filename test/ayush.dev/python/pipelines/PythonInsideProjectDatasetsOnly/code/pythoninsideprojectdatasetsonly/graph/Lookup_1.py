from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from pythoninsideprojectdatasetsonly.config.ConfigStore import *
from pythoninsideprojectdatasetsonly.udfs.UDFs import *

def Lookup_1(spark: SparkSession, in0: DataFrame):
    keyColumns = ['''customer_id''', '''email''']
    valueColumns = ['''first_name''', '''last_name''']
    createLookup("LookupMain", in0, spark, keyColumns, valueColumns)
