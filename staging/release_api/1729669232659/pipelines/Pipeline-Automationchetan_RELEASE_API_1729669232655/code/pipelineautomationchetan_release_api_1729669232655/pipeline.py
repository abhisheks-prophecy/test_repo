from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from pipelineautomationchetan_release_api_1729669232655.config.ConfigStore import *
from pipelineautomationchetan_release_api_1729669232655.functions import *
from prophecy.utils import *
from pipelineautomationchetan_release_api_1729669232655.graph import *

def pipeline(spark: SparkSession) -> None:
    df_Project_Automationchetan_python_RELEASE_API_dataSet = Project_Automationchetan_python_RELEASE_API_dataSet(spark)
    df_select_customer_details = select_customer_details(spark, df_Project_Automationchetan_python_RELEASE_API_dataSet)

def main():
    spark = SparkSession.builder\
                .config("spark.default.parallelism", "4")\
                .config("spark.sql.legacy.allowUntypedScalaUDF", "true")\
                .enableHiveSupport()\
                .appName("Pipeline-Automationchetan_RELEASE_API_1729669232655")\
                .getOrCreate()
    Utils.initializeFromArgs(spark, parse_args())
    spark.conf.set("prophecy.metadata.pipeline.uri", "pipelines/Pipeline-Automationchetan_RELEASE_API_1729669232655")
    registerUDFs(spark)
    
    MetricsCollector.instrument(
        spark = spark,
        pipelineId = "pipelines/Pipeline-Automationchetan_RELEASE_API_1729669232655",
        config = Config
    )(
        pipeline
    )

if __name__ == "__main__":
    main()
