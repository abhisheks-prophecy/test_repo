from setuptools import setup, find_packages
setup(
    name = 'Pipeline-Automationchetan_RELEASE_API_1729669232655',
    version = '1.0',
    packages = find_packages(include = ('pipelineautomationchetan_release_api_1729669232655*', )) + ['prophecy_config_instances'],
    package_dir = {'prophecy_config_instances' : 'configs/resources/config'},
    package_data = {'prophecy_config_instances' : ['*.json', '*.py', '*.conf']},
    description = 'workflow',
    install_requires = [
'prophecy-libs==1.9.22'],
    entry_points = {
'console_scripts' : [
'main = pipelineautomationchetan_release_api_1729669232655.pipeline:main'], },
    data_files = [(".prophecy", [".prophecy/workflow.latest.json"])],
    extras_require = {
'test' : ['pytest', 'pytest-html'], }
)
