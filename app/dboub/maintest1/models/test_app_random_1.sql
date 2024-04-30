WITH all_type_non_partitioned AS (

  SELECT * 
  
  FROM {{ source('hive_metastore.qa_database', 'all_type_non_partitioned') }}

),

Reformat_1 AS (

  SELECT c_tinyint AS c_tinyint
  
  FROM all_type_non_partitioned AS in0

)

SELECT *

FROM Reformat_1
