{% macro qa_basic_not_null_gem_simple_base(model, colname) %}
select * from {{model}} where {{colname}} is not null
{% endmacro %}

 