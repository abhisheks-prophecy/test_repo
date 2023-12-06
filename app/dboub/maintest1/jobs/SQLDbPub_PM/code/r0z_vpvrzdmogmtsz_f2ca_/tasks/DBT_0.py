def DBT_0():
    from datetime import timedelta
    from airflow.operators.bash import BashOperator

    return BashOperator(
        task_id = "DBT_0",
        bash_command = "$PROPHECY_HOME/run_dbt.sh \"dbt deps --profile run_profile; dbt seed --profile run_profile; dbt run --profile run_profile; dbt test --profile run_profile; \"",
        env = {
          "DBT_FULL_REFRESH": "true", 
          "DBT_PROFILE_SECRET": "7S1Y8SUv9agvBbj2YeFlp", 
          "GIT_TOKEN_SECRET": "SlePlIeXQ20jXYJU7lHFww_", 
          "GIT_ENTITY": "branch", 
          "GIT_ENTITY_VALUE": "main", 
          "GIT_SSH_URL": "https://github.com/abhisheks-prophecy/sql_db_app", 
          "GIT_SUB_PATH": ""
        },
        append_env = True,
    )
