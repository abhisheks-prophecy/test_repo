from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from pyprepipeline.config.ConfigStore import *
from pyprepipeline.udfs.UDFs import *
from prophecy.utils import *
from pyprepipeline.graph import *

def pipeline(spark: SparkSession) -> None:
    df_src_warehouse = src_warehouse(spark)
    df_Deduplicate_1 = Deduplicate_1(spark, df_src_warehouse)
    dest_warehouse(spark, df_Deduplicate_1)
    df_src_delta = src_delta(spark)
    df_OrderBy_1 = OrderBy_1(spark, df_src_delta)
    dest_delta(spark, df_OrderBy_1)
    df_src_parquet_complex = src_parquet_complex(spark)
    df_src_catalog = src_catalog(spark)
    df_Subgraph_1 = Subgraph_1(spark, df_src_catalog)
    df_Reformat_5 = Reformat_5(spark, df_Subgraph_1)
    df_Reformat_1 = Reformat_1(spark, df_src_parquet_complex)
    dest_parquet(spark, df_Reformat_1)
    df_FlattenSchema_1 = FlattenSchema_1(spark, df_src_catalog)
    df_src_csv = src_csv(spark)
    df_Filter_1 = Filter_1(spark, df_src_csv)
    df_testSG_main1_1 = testSG_main1_1(spark, df_src_catalog)
    dest_csv(spark, df_Filter_1)

def main():
    spark = SparkSession.builder\
                .config("spark.default.parallelism", "4")\
                .config("spark.sql.legacy.allowUntypedScalaUDF", "true")\
                .enableHiveSupport()\
                .appName("Prophecy Pipeline")\
                .getOrCreate()\
                .newSession()
    Utils.initializeFromArgs(spark, parse_args())
    spark.conf.set("prophecy.metadata.pipeline.uri", "10738/pipelines/PyPrePipeline")
    MetricsCollector.start(spark = spark, pipelineId = "10738/pipelines/PyPrePipeline")
    pipeline(spark)
    MetricsCollector.end(spark)

if __name__ == "__main__":
    main()
