from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from python_external_git_pipeline.config.ConfigStore import *
from python_external_git_pipeline.udfs.UDFs import *

def src_catalog(spark: SparkSession) -> DataFrame:
    return spark.read.table(f"qa_database.all_type_parquet")
