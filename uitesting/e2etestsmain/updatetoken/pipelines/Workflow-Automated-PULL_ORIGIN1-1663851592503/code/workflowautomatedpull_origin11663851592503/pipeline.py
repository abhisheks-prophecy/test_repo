from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from workflowautomatedpull_origin11663851592503.config.ConfigStore import *
from workflowautomatedpull_origin11663851592503.udfs.UDFs import *
from prophecy.utils import *
from workflowautomatedpull_origin11663851592503.graph import *

def pipeline(spark: SparkSession) -> None:
    df_Script_0 = Script_0(spark)

def main():
    spark = SparkSession.builder\
                .config("spark.default.parallelism", "4")\
                .config("spark.sql.legacy.allowUntypedScalaUDF", "true")\
                .enableHiveSupport()\
                .appName("Prophecy Pipeline")\
                .getOrCreate()\
                .newSession()
    Utils.initializeFromArgs(spark, parse_args())
    spark.conf.set("prophecy.metadata.pipeline.uri", "10536/pipelines/Workflow-Automated-PULL_ORIGIN1-1663851592503")
    MetricsCollector.start(spark = spark, pipelineId = "10536/pipelines/Workflow-Automated-PULL_ORIGIN1-1663851592503")
    pipeline(spark)
    MetricsCollector.end(spark)

if __name__ == "__main__":
    main()
