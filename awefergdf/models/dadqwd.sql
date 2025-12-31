WITH customer AS (

  SELECT * 
  
  FROM {{ source('samples_tpch', 'customer') }}

)

SELECT *

FROM customer
