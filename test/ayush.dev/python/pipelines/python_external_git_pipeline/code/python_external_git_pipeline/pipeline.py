from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from python_external_git_pipeline.config.ConfigStore import *
from python_external_git_pipeline.udfs.UDFs import *
from prophecy.utils import *
from python_external_git_pipeline.graph import *

def pipeline(spark: SparkSession) -> None:
    df_src_jdbc = src_jdbc(spark)
    df_src_json = src_json(spark)
    df_Filter_1 = Filter_1(spark, df_src_json)
    df_test_subgraph_1 = test_subgraph_1(spark, df_Filter_1)
    df_SetOperation_1 = SetOperation_1(spark, df_src_jdbc, df_src_jdbc)
    df_src_parquet = src_parquet(spark)
    df_Deduplicate_1 = Deduplicate_1(spark, df_src_parquet)
    df_Subgraph_1 = Subgraph_1(spark, df_Filter_1)
    df_src_catalog = src_catalog(spark)
    df_Reformat_1 = Reformat_1(spark, df_src_catalog)
    df_src_avro = src_avro(spark)
    df_Join_1 = Join_1(spark, df_src_avro, df_src_avro)
    df_src_parquet_complex = src_parquet_complex(spark)
    df_FlattenSchema_1 = FlattenSchema_1(spark, df_src_parquet_complex)
    df_customers = customers(spark)
    df_OrderBy_1 = OrderBy_1(spark, df_src_parquet_complex)
    df_src_orc = src_orc(spark)
    df_src_csv = src_csv(spark)
    df_Reformat_3 = Reformat_3(spark, df_customers)
    df_RowDistributor_1_out0, df_RowDistributor_1_out1 = RowDistributor_1(spark, df_src_orc)
    df_SchemaTransform_1 = SchemaTransform_1(spark, df_src_csv)

def main():
    spark = SparkSession.builder\
                .config("spark.default.parallelism", "4")\
                .config("spark.sql.legacy.allowUntypedScalaUDF", "true")\
                .enableHiveSupport()\
                .appName("Prophecy Pipeline")\
                .getOrCreate()\
                .newSession()
    Utils.initializeFromArgs(spark, parse_args())
    spark.conf.set("prophecy.metadata.pipeline.uri", "pipelines/python_external_git_pipeline")
    
    MetricsCollector.start(
        spark = spark,
        pipelineId = spark.conf.get("prophecy.project.id") + "/" + "pipelines/python_external_git_pipeline"
    )
    pipeline(spark)
    MetricsCollector.end(spark)

if __name__ == "__main__":
    main()
