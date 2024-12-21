from setuptools import setup, find_packages
setup(
    name = 'TEST_MAIN',
    version = '1.0',
    packages = find_packages(include = ('test_main*', )) + ["prophecy_config_instances"],
    package_dir = {'prophecy_config_instances' : 'configs/resources/config'},
    package_data = {'prophecy_config_instances' : ['*.json', '*.py']},
    description = 'workflow',
    install_requires = [
'prophecy-libs==1.3.11'],
    entry_points = {
'console_scripts' : [
'main = test_main.pipeline:main'], },
    data_files = [(".prophecy", [".prophecy/workflow.latest.json"])],
    extras_require = {
'test' : ['pytest', 'pytest-html'], }
)