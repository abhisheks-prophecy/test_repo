from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from pypipshareddataset.config.ConfigStore import *
from pypipshareddataset.udfs.UDFs import *
from prophecy.utils import *
from pypipshareddataset.graph import *

def pipeline(spark: SparkSession) -> None:
    df_customers = customers(spark)
    df_Reformat_1 = Reformat_1(spark, df_customers)
    df_src_delta = src_delta(spark)

def main():
    spark = SparkSession.builder\
                .config("spark.default.parallelism", "4")\
                .config("spark.sql.legacy.allowUntypedScalaUDF", "true")\
                .enableHiveSupport()\
                .appName("Prophecy Pipeline")\
                .getOrCreate()\
                .newSession()
    Utils.initializeFromArgs(spark, parse_args())
    spark.conf.set("prophecy.metadata.pipeline.uri", "10738/pipelines/PyPipSharedDataset")
    MetricsCollector.start(spark = spark, pipelineId = "10738/pipelines/PyPipSharedDataset")
    pipeline(spark)
    MetricsCollector.end(spark)

if __name__ == "__main__":
    main()
