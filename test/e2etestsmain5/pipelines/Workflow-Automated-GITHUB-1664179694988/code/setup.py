from setuptools import setup, find_packages
setup(
    name = 'Workflow-Automated-GITHUB-1664179694988',
    version = '1.0',
    packages = find_packages(include = ('workflowautomatedgithub1664179694988*', )) + ["prophecy_config_instances"],
    package_dir = {'prophecy_config_instances' : 'configs/resources/config'},
    package_data = {'prophecy_config_instances' : ['*.json', '*.py']},
    description = 'workflow',
    install_requires = [
'prophecy-libs==1.3.5'],
    entry_points = {
'console_scripts' : [
'main = workflowautomatedgithub1664179694988.pipeline:main', ], },
    extras_require = {
'test' : ['pytest', 'pytest-html'], }
)
