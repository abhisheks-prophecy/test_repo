from setuptools import setup, find_packages
setup(
    name = 'Workflow-Automated-PULL_ORIGIN1-1663851592503',
    version = '1.0',
    packages = find_packages(include = ('workflowautomatedpull_origin11663851592503*', )) + ["prophecy_config_instances"],
    package_dir = {'prophecy_config_instances' : 'configs/resources/config'},
    package_data = {'prophecy_config_instances' : ['*.json', '*.py']},
    description = 'workflow',
    install_requires = [
'prophecy-libs==1.3.5'],
    entry_points = {
'console_scripts' : [
'main = workflowautomatedpull_origin11663851592503.pipeline:main', ], },
    extras_require = {
'test' : ['pytest', 'pytest-html'], }
)
