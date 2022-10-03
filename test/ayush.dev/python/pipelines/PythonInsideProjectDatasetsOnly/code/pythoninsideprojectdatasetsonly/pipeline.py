from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from pythoninsideprojectdatasetsonly.config.ConfigStore import *
from pythoninsideprojectdatasetsonly.udfs.UDFs import *
from prophecy.utils import *
from pythoninsideprojectdatasetsonly.graph import *

def pipeline(spark: SparkSession) -> None:
    df_src_avro = src_avro(spark)
    Lookup_1(spark, df_src_avro)
    df_src_catalog = src_catalog(spark)
    df_Script_1 = Script_1(spark, df_src_catalog)
    df_SQLStatement_1 = SQLStatement_1(spark, df_Script_1)
    df_RowDistributor_1_out0, df_RowDistributor_1_out1 = RowDistributor_1(spark, df_SQLStatement_1)
    df_Join_1 = Join_1(spark, df_RowDistributor_1_out0, df_RowDistributor_1_out1)
    df_src_avro_1 = src_avro_1(spark)
    df_src_json = src_json(spark)
    df_Filter_1 = Filter_1(spark, df_src_json)
    df_SetOperation_1 = SetOperation_1(spark, df_Filter_1, df_Filter_1)
    df_SchemaTransform_1 = SchemaTransform_1(spark, df_SetOperation_1)
    df_Aggregate_1 = Aggregate_1(spark, df_SchemaTransform_1)
    df_WindowFunction_1 = WindowFunction_1(spark, df_Aggregate_1)
    df_Deduplicate_2 = Deduplicate_2(spark, df_WindowFunction_1)
    df_Reformat_1 = Reformat_1(spark, df_src_avro)
    df_OrderBy_1 = OrderBy_1(spark, df_Reformat_1)
    df_Limit_1 = Limit_1(spark, df_OrderBy_1)
    df_Script_2 = Script_2(spark, df_Join_1)
    df_src_orc = src_orc(spark)
    df_Subgraph_1 = Subgraph_1(spark, df_src_catalog)
    df_PythonSG_1 = PythonSG_1(spark, df_Subgraph_1)
    df_PythonSG_2 = PythonSG_2(spark, df_PythonSG_1)
    df_PythonSG_3 = PythonSG_3(spark, df_PythonSG_2)
    df_src_parquet_1 = src_parquet_1(spark)
    df_FlattenSchema_1 = FlattenSchema_1(spark, df_src_orc)

def main():
    spark = SparkSession.builder\
                .config("spark.default.parallelism", "4")\
                .config("spark.sql.legacy.allowUntypedScalaUDF", "true")\
                .enableHiveSupport()\
                .appName("Prophecy Pipeline")\
                .getOrCreate()\
                .newSession()
    Utils.initializeFromArgs(spark, parse_args())
    spark.conf.set("prophecy.metadata.pipeline.uri", "pipelines/PythonInsideProjectDatasetsOnly")
    
    MetricsCollector.start(
        spark = spark,
        pipelineId = spark.conf.get("prophecy.project.id") + "/" + "pipelines/PythonInsideProjectDatasetsOnly"
    )
    pipeline(spark)
    MetricsCollector.end(spark)

if __name__ == "__main__":
    main()
