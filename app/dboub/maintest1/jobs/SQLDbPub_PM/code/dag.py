import os
import sys
import pendulum
from datetime import timedelta
import airflow
from airflow import DAG
from airflow.decorators import task
from airflow.models.param import Param
sys.path.insert(0, os.path.abspath(os.path.dirname(__file__)))
from r0z_vpvrzdmogmtsz_f2ca_.tasks import DBT_0
PROPHECY_RELEASE_TAG = "__PROJECT_ID_PLACEHOLDER__/__PROJECT_RELEASE_VERSION_PLACEHOLDER__"

with DAG(
    dag_id = "R0z_VPVRZDMoGMTsz_F2cA_", 
    schedule_interval = "0 0 * * 5", 
    default_args = {"owner" : "Prophecy", "retries" : 0, "ignore_first_depends_on_past" : True, "do_xcom_push" : True, "pool" : "XIwAt2Jp"}, 
    start_date = pendulum.today('UTC'), 
    end_date = pendulum.datetime(2023, 12, 27, tz = "UTC"), 
    catchup = True, 
    tags = []
) as dag:
    DBT_0_op = DBT_0()
