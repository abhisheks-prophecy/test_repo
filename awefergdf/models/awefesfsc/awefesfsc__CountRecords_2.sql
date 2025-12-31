{{
  config({    
    "materialized": "ephemeral",
    "database": "qa_database",
    "schema": "qa_orchestration"
  })
}}

WITH customer AS (

  SELECT * 
  
  FROM {{ source('samples_tpch', 'customer') }}

),

CountRecords_1 AS (

  {{ prophecy_basics.CountRecords(['customer'], [], 'count_all_records') }}

),

CountRecords_2 AS (

  {{ prophecy_basics.CountRecords(['CountRecords_1'], [], 'count_all_records') }}

)

SELECT *

FROM CountRecords_2
