from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from livy_python.config.ConfigStore import *
from livy_python.udfs.UDFs import *
from prophecy.utils import *
from livy_python.graph import *

def pipeline(spark: SparkSession) -> None:
    df_src_livy = src_livy(spark)
    df_Reformat_1 = Reformat_1(spark, df_src_livy)

def main():
    spark = SparkSession.builder\
                .config("spark.default.parallelism", "4")\
                .config("spark.sql.legacy.allowUntypedScalaUDF", "true")\
                .enableHiveSupport()\
                .appName("Prophecy Pipeline")\
                .getOrCreate()\
                .newSession()
    Utils.initializeFromArgs(spark, parse_args())
    spark.conf.set("prophecy.metadata.pipeline.uri", "pipelines/livy_python")
    
    MetricsCollector.start(
        spark = spark,
        pipelineId = spark.conf.get("prophecy.project.id") + "/" + "pipelines/livy_python"
    )
    pipeline(spark)
    MetricsCollector.end(spark)

if __name__ == "__main__":
    main()
