{{
  config({    
    "materialized": "ephemeral",
    "database": "qa_team",
    "schema": "qa_orchestration"
  })
}}

WITH customer AS (

  SELECT * 
  
  FROM {{ source('samples.tpch', 'customer') }}

),

CountRecords_1 AS (

  {{ prophecy_basics.CountRecords(['customer'], [], 'count_all_records') }}

)

SELECT *

FROM CountRecords_1
