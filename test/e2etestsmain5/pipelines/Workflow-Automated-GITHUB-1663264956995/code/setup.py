from setuptools import setup, find_packages
setup(
    name = 'Workflow-Automated-GITHUB-1663264956995',
    version = '1.0',
    packages = find_packages(include = ('workflowautomatedgithub1663264956995*', )),
    description = 'workflow',
    install_requires = [
'prophecy-libs==1.3.4'],
    entry_points = {
'console_scripts' : [
'main = workflowautomatedgithub1663264956995.pipeline:main', ], },
    extras_require = {
'test' : ['pytest', 'pytest-html'], }
)
