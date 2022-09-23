from setuptools import setup, find_packages
setup(
    name = 'Workflow-Automated-GITHUB-1663688892148',
    version = '1.0',
    packages = find_packages(include = ('workflowautomatedgithub1663688892148*', )) + ["prophecy_config_instances"],
    package_dir = {'prophecy_config_instances' : 'configs/resources/config'},
    package_data = {'prophecy_config_instances' : ['*.json', '*.py']},
    description = 'workflow',
    install_requires = [
'prophecy-libs==1.3.5'],
    entry_points = {
'console_scripts' : [
'main = workflowautomatedgithub1663688892148.pipeline:main', ], },
    extras_require = {
'test' : ['pytest', 'pytest-html'], }
)
