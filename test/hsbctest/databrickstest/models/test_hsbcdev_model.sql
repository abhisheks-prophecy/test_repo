

{% set TEST_PASSWORD_MODEL_VAR = "TEST_PASSWORD_MODEL_VAR" %}
{% set C_MODEL_PASSWORD = "C_MODEL_PASSWORD" %}


WITH raw_orders AS (

  SELECT * 
  
  FROM {{ ref('raw_orders')}}

),

all_map_type_table AS (

  SELECT * 
  
  FROM {{ source('hive_metastore.qa_database', 'all_map_type_table') }}

),

Reformat_1 AS (

  SELECT 
    c_int AS c_int,
    c_string AS c_string,
    c_map_ts_int_int AS c_map_ts_int_int,
    c_map_ts_string_string AS c_map_ts_string_string,
    c_map_ts_timestamp_int AS c_map_ts_timestamp_int,
    c_map_complex AS c_map_complex
  
  FROM all_map_type_table AS in0

),

Join_1 AS (

  SELECT 
    in0.c_int AS c_int,
    concat(
      in0.c_string, 
      {{ SQL_Databricks.qa_concat_macro_column('in0.c_string') }}, 
      'password', 
      '{{ C_MODEL_PASSWORD }}', 
      '{{ var("TEST_PASSWORD_PROJECT_VAR") }}') AS c_string,
    in0.c_map_ts_int_int AS c_map_ts_int_int,
    in0.c_map_ts_string_string AS c_map_ts_string_string,
    in0.c_map_ts_timestamp_int AS c_map_ts_timestamp_int,
    in0.c_map_complex AS c_map_complex,
    in1.id AS id,
    in1.user_id AS user_id,
    in1.order_date AS order_date,
    in1.status AS status
  
  FROM Reformat_1 AS in0
  INNER JOIN raw_orders AS in1
     ON in0.c_int != in1.id

),

qa_all_not_null_1 AS (

  {{ SQL_Databricks.qa_all_not_null(model_password = 'Join_1', column_name = 'c_int') }}

)

SELECT *

FROM qa_all_not_null_1
