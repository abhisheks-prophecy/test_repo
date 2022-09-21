from setuptools import setup, find_packages
setup(
    name = 'Workflow-Automated-GITHUB-1658145819235',
    version = '1.0',
    packages = find_packages(include = ('job*', )),
    description = 'workflow',
    install_requires = [
'prophecy-libs==1.1.13.1'],
    entry_points = {
'console_scripts' : [
'main = job.pipeline:main', ], },
    extras_require = {
'test' : ['pytest', 'pytest-html'], }
)
