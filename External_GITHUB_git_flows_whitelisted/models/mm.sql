

{% set hgj = "'asd'" %}

WITH customer AS (

  SELECT * 
  
  FROM {{ source('samples.tpch', 'customer') }}

)

SELECT *

FROM customer
