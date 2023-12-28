{% macro qa_basic_not_null_forked_gem_base_snow(model, colname) %}
select * from {{model}} where {{colname}} is not null
{% endmacro %}
