import os
import sys
import pendulum
from datetime import timedelta
import airflow
from airflow import DAG
from airflow.decorators import task
from airflow.models.param import Param
sys.path.insert(0, os.path.abspath(os.path.dirname(__file__)))
from abhisheks_e2etests_sql_dbpublic_sqldbpub_composer.tasks import DBT_0, Script_1
PROPHECY_RELEASE_TAG = "__PROJECT_ID_PLACEHOLDER__/__PROJECT_RELEASE_VERSION_PLACEHOLDER__"

with DAG(
    dag_id = "abhisheks_e2etests_SQL_DBPublic_SQLDbPub_Composer", 
    schedule_interval = "0 0 1 7 *", 
    default_args = {"owner" : "Prophecy", "retries" : 0, "ignore_first_depends_on_past" : True, "do_xcom_push" : True}, 
    start_date = pendulum.today('UTC'), 
    catchup = True, 
    tags = []
) as dag:
    DBT_0_op = DBT_0()
    Script_1_op = Script_1()
    DBT_0_op >> Script_1_op
