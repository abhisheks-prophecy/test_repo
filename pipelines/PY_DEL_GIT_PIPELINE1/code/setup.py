from setuptools import setup, find_packages
setup(
    name = 'PY_DEP_PIPELINE1',
    version = '1.0',
    packages = find_packages(include = ('py_del_git_pipeline1*', )) + ["prophecy_config_instances"],
    package_dir = {'prophecy_config_instances' : 'configs/resources/config'},
    package_data = {'prophecy_config_instances' : ['*.json', '*.py']},
    description = 'workflow',
    install_requires = [
'pyhocon==0.3.59', 'prophecy-libs==1.3.11'],
    entry_points = {
'console_scripts' : [
'main = py_del_git_pipeline1.pipeline:main'], },
    data_files = [(".prophecy", [".prophecy/workflow.latest.json"])],
    extras_require = {
'test' : ['pytest', 'pytest-html'], }
)
