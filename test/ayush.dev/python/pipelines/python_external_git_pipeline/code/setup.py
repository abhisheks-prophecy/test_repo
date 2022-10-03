from setuptools import setup, find_packages
setup(
    name = 'python_external_git_pipeline',
    version = '1.0',
    packages = find_packages(include = ('python_external_git_pipeline*', )) + ["prophecy_config_instances"],
    package_dir = {'prophecy_config_instances' : 'configs/resources/config'},
    package_data = {'prophecy_config_instances' : ['*.json', '*.py']},
    description = 'workflow',
    install_requires = [
'matplotlib==3.5.2', 'prophecy-libs==1.3.6'],
    entry_points = {
'console_scripts' : [
'main = python_external_git_pipeline.pipeline:main', ], },
    extras_require = {
'test' : ['pytest', 'pytest-html'], }
)
