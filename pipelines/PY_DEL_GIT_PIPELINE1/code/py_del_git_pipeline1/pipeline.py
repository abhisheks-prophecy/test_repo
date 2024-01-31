from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from py_del_git_pipeline1.config.ConfigStore import *
from py_del_git_pipeline1.udfs.UDFs import *
from prophecy.utils import *
from py_del_git_pipeline1.graph import *

def pipeline(spark: SparkSession) -> None:
    df_src_json_input_custs_0 = src_json_input_custs_0(spark)
    df_Script_2 = Script_2(spark, df_src_json_input_custs_0)
    df_Reformat_1 = Reformat_1(spark, df_src_json_input_custs_0)
    df_Reformat_3 = Reformat_3(spark, df_Script_2)
    df_ALL_TYPE_CSV_1 = ALL_TYPE_CSV_1(spark)
    df_Reformat_2 = Reformat_2(spark, df_ALL_TYPE_CSV_1)
    df_Script_1 = Script_1(spark, df_src_json_input_custs_0)
    df_Reformat_2_1 = Reformat_2_1(spark, df_Script_1)

def main():
    spark = SparkSession.builder\
                .config("spark.default.parallelism", "4")\
                .config("spark.sql.legacy.allowUntypedScalaUDF", "true")\
                .enableHiveSupport()\
                .appName("Prophecy Pipeline")\
                .getOrCreate()\
                .newSession()
    Utils.initializeFromArgs(spark, parse_args())
    spark.conf.set("prophecy.metadata.pipeline.uri", "pipelines/PY_DEL_GIT_PIPELINE1")
    
    MetricsCollector.start(
        spark = spark,
        pipelineId = spark.conf.get("prophecy.project.id") + "/" + "pipelines/PY_DEL_GIT_PIPELINE1"
    )
    pipeline(spark)
    MetricsCollector.end(spark)

if __name__ == "__main__":
    main()
