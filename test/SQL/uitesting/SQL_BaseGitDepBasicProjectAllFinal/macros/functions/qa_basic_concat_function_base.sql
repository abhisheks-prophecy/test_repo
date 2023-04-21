{% macro qa_basic_concat_function_base(param1_col, param2_col) %}
concat({{param1_col}}, {{param2_col}})
{% endmacro %}
