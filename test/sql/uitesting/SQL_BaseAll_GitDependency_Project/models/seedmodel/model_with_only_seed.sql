WITH country_classification AS (

  SELECT * 
  
  FROM {{ ref('country_classification')}}

),

service_classification AS (

  SELECT * 
  
  FROM {{ ref('service_classification')}}

),

Join_1 AS (

  SELECT 
    in0.country_code AS country_code,
    in0.country_label AS country_label,
    in1.code AS code,
    in1.service_label AS service_label
  
  FROM country_classification AS in0
  INNER JOIN service_classification AS in1
     ON in0.country_code != in1.code

)

SELECT *

FROM Join_1
