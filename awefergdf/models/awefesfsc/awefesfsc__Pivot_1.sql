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

Pivot_1 AS (

  SELECT * 
  
  FROM CountRecords_1 AS in0

)

SELECT *

FROM Pivot_1
