from setuptools import setup, find_packages
setup(
    name = 'Workflow-Automated-GITHUB-1656274629186',
    version = '1.0',
    packages = find_packages(include = ('job*', )),
    description = 'workflow',
    install_requires = [
'prophecy-libs==1.1.8'],
    entry_points = {
'console_scripts' : [
'main = job.pipeline:main', ], },
    extras_require = {
'test' : ['pytest', 'pytest-html'], }
)
