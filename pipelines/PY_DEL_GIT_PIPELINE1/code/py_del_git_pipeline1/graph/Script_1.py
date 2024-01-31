from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from py_del_git_pipeline1.config.ConfigStore import *
from py_del_git_pipeline1.udfs.UDFs import *

def Script_1(spark: SparkSession, in0: DataFrame) -> DataFrame:
    import subprocess
    result = subprocess.run(["ls"], capture_output = True, text = True)
    # result1=subprocess.run(["pwd"], capture_output=True, text=True)
    data = [StructField(item, StringType(), True) for item in result.stdout.split("\n")]
    # data.append((result1.stdout,))
    print(data)
    deptDF = spark.createDataFrame(data = [], schema = StructType(data))
    deptDF.printSchema()
    out0 = deptDF

    return out0
