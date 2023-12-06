WITH basic_orders AS (

  SELECT * 
  
  FROM {{ ref('basic_orders')}}

),

basic_payments AS (

  SELECT * 
  
  FROM {{ ref('basic_payments')}}

),

Macro_1 AS (

  {{ SQL_BaseGitDepBasicSnowFinal.qa_basic_not_null_forked_gem_base_snow(model = 'basic_payments', colname = 'payment_method') }}

),

basic_customers AS (

  SELECT * 
  
  FROM {{ ref('basic_customers')}}

),

Join_1 AS (

  SELECT 
    in0.id AS id,
    in0.first_name AS first_name,
    in0.last_name AS last_name,
    in1.id AS order_id_main,
    in1.user_id AS user_id_main,
    in1.order_date AS order_date,
    in1.status AS status,
    in2.ID AS payments_id,
    in2.ORDER_ID AS ORDER_ID,
    in2.PAYMENT_METHOD AS PAYMENT_METHOD,
    in2.AMOUNT AS AMOUNT
  
  FROM basic_customers AS in0
  INNER JOIN basic_orders AS in1
     ON in0.first_name != in1.status
  INNER JOIN Macro_1 AS in2
     ON in1.status != in2.PAYMENT_METHOD

),

Reformat_1 AS (

  SELECT * 
  
  FROM Join_1 AS in0

)

SELECT *

FROM Reformat_1
