from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from test_main.config.ConfigStore import *
from test_main.udfs.UDFs import *
from prophecy.utils import *
from test_main.graph import *

def pipeline(spark: SparkSession) -> None:
    df_src_parquet = src_parquet(spark)
    df_Reformat_2 = Reformat_2(spark, df_src_parquet)
    df_src_csv_test = src_csv_test(spark)
    df_Reformat_1 = Reformat_1(spark, df_src_csv_test)

def main():
    spark = SparkSession.builder\
                .config("spark.default.parallelism", "4")\
                .config("spark.sql.legacy.allowUntypedScalaUDF", "true")\
                .enableHiveSupport()\
                .appName("Prophecy Pipeline")\
                .getOrCreate()\
                .newSession()
    Utils.initializeFromArgs(spark, parse_args())
    spark.conf.set("prophecy.metadata.pipeline.uri", "pipelines/TEST_MAIN")
    
    MetricsCollector.start(spark = spark, pipelineId = spark.conf.get("prophecy.project.id") + "/" + "pipelines/TEST_MAIN")
    pipeline(spark)
    MetricsCollector.end(spark)

if __name__ == "__main__":
    main()