{% macro qa_basic_concat_function_base_snow(param1_col, param2_col) %}
concat({{param1_col}}, {{param2_col}})
{% endmacro %}
