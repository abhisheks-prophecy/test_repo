from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from pythonlivy.config.ConfigStore import *
from pythonlivy.udfs.UDFs import *
from prophecy.utils import *
from pythonlivy.graph import *

def pipeline(spark: SparkSession) -> None:
    df_src_livy = src_livy(spark)
    df_Deduplicate_1 = Deduplicate_1(spark, df_src_livy)
    df_Reformat_1 = Reformat_1(spark, df_Deduplicate_1)
    df_Join_1 = Join_1(spark, df_Reformat_1, df_Reformat_1)
    df_Subgraph_1 = Subgraph_1(spark, df_src_livy)
    df_SG_LIVY_1 = SG_LIVY_1(spark, df_Subgraph_1)

def main():
    spark = SparkSession.builder\
                .config("spark.default.parallelism", "4")\
                .config("spark.sql.legacy.allowUntypedScalaUDF", "true")\
                .enableHiveSupport()\
                .appName("Prophecy Pipeline")\
                .getOrCreate()\
                .newSession()
    Utils.initializeFromArgs(spark, parse_args())
    spark.conf.set("prophecy.metadata.pipeline.uri", "pipelines/PythonLivy")
    
    MetricsCollector.start(
        spark = spark,
        pipelineId = spark.conf.get("prophecy.project.id") + "/" + "pipelines/PythonLivy"
    )
    pipeline(spark)
    MetricsCollector.end(spark)

if __name__ == "__main__":
    main()
