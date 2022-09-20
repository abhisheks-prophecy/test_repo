from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from workflowautomatedgithub1663688285635.config.ConfigStore import *
from workflowautomatedgithub1663688285635.udfs.UDFs import *
from prophecy.utils import *
from workflowautomatedgithub1663688285635.graph import *

def pipeline(spark: SparkSession) -> None:
    df_dataset_cust_in = dataset_cust_in(spark)
    df_Filter_1 = Filter_1(spark, df_dataset_cust_in)
    dataset_out_3274(spark, df_Filter_1)

def main():
    spark = SparkSession.builder\
                .config("spark.default.parallelism", "4")\
                .config("spark.sql.legacy.allowUntypedScalaUDF", "true")\
                .enableHiveSupport()\
                .appName("Prophecy Pipeline")\
                .getOrCreate()\
                .newSession()
    Utils.initializeFromArgs(spark, parse_args())
    spark.conf.set("prophecy.metadata.pipeline.uri", "13930/pipelines/Workflow-Automated-GITHUB-1663688285635")
    MetricsCollector.start(spark = spark, pipelineId = "13930/pipelines/Workflow-Automated-GITHUB-1663688285635")
    pipeline(spark)
    MetricsCollector.end(spark)

if __name__ == "__main__":
    main()
