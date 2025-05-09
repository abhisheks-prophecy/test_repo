from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from testpipelinenonmain.config.ConfigStore import *
from testpipelinenonmain.udfs.UDFs import *
from prophecy.utils import *
from testpipelinenonmain.graph import *

def pipeline(spark: SparkSession) -> None:
    df_testdataset = testdataset(spark)
    df_Reformat_1 = Reformat_1(spark, df_testdataset)

def main():
    spark = SparkSession.builder\
                .config("spark.default.parallelism", "4")\
                .config("spark.sql.legacy.allowUntypedScalaUDF", "true")\
                .enableHiveSupport()\
                .appName("Prophecy Pipeline")\
                .getOrCreate()\
                .newSession()
    Utils.initializeFromArgs(spark, parse_args())
    spark.conf.set("prophecy.metadata.pipeline.uri", "pipelines/TESTPipelineNonMain")
    
    MetricsCollector.start(
        spark = spark,
        pipelineId = spark.conf.get("prophecy.project.id") + "/" + "pipelines/TESTPipelineNonMain"
    )
    pipeline(spark)
    MetricsCollector.end(spark)

if __name__ == "__main__":
    main()
