from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from job.config.ConfigStore import *
from job.udfs.UDFs import *

def Script_1(spark: SparkSession, in0: DataFrame) -> DataFrame:
    import pandas as pd
    data = {
"calories" : [420, 380, 390], "duration" : [50, 40, 45]}
    df = pd.DataFrame(data)
    print(df)
    import numpy as np
    arr = np.array([1, 2, 3, 4, 5])
    print(arr)
    out0 = in0

    return out0
