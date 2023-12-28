from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from testrevokedaccess.config.ConfigStore import *
from testrevokedaccess.udfs.UDFs import *
from prophecy.utils import *
from testrevokedaccess.graph import *

def pipeline(spark: SparkSession) -> None:
    df_TEST_REVOKE_ACCESS = TEST_REVOKE_ACCESS(spark)
    df_src_avro = src_avro(spark)
    df_Reformat_1 = Reformat_1(spark, df_src_avro)
    df_Reformat_2 = Reformat_2(spark, df_TEST_REVOKE_ACCESS)

def main():
    spark = SparkSession.builder\
                .config("spark.default.parallelism", "4")\
                .config("spark.sql.legacy.allowUntypedScalaUDF", "true")\
                .enableHiveSupport()\
                .appName("Prophecy Pipeline")\
                .getOrCreate()\
                .newSession()
    Utils.initializeFromArgs(spark, parse_args())
    spark.conf.set("prophecy.metadata.pipeline.uri", "pipelines/TestRevokedAccess")
    
    MetricsCollector.start(
        spark = spark,
        pipelineId = spark.conf.get("prophecy.project.id") + "/" + "pipelines/TestRevokedAccess"
    )
    pipeline(spark)
    MetricsCollector.end(spark)

if __name__ == "__main__":
    main()
