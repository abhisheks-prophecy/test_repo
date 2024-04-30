from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from pipeline_dataset_different_account_teams.config.ConfigStore import *
from pipeline_dataset_different_account_teams.udfs.UDFs import *
from prophecy.utils import *
from pipeline_dataset_different_account_teams.graph import *

def pipeline(spark: SparkSession) -> None:
    df_customers_orders = customers_orders(spark)
    df_customers = customers(spark)
    df_Reformat_2 = Reformat_2(spark, df_customers_orders)
    df_Reformat_1 = Reformat_1(spark, df_customers)

def main():
    spark = SparkSession.builder\
                .config("spark.default.parallelism", "4")\
                .config("spark.sql.legacy.allowUntypedScalaUDF", "true")\
                .enableHiveSupport()\
                .appName("Prophecy Pipeline")\
                .getOrCreate()\
                .newSession()
    Utils.initializeFromArgs(spark, parse_args())
    spark.conf.set("prophecy.metadata.pipeline.uri", "pipelines/pipeline_dataset_different_account_teams")
    
    MetricsCollector.start(
        spark = spark,
        pipelineId = spark.conf.get("prophecy.project.id") + "/" + "pipelines/pipeline_dataset_different_account_teams"
    )
    pipeline(spark)
    MetricsCollector.end(spark)

if __name__ == "__main__":
    main()
