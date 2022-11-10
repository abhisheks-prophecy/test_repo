from setuptools import setup, find_packages
setup(
    name = 'python_externalgit_pipeline',
    version = '1.0',
    packages = find_packages(include = ('job*', )),
    description = 'workflow',
    install_requires = [
'prophecy-libs==1.1.1', 'numpy==1.22.*', 'pandas>=1.4.2', 'requests~=2.28.0'],
    entry_points = {
'console_scripts' : [
'main = job.pipeline:main', ], },
    tests_require = ['pytest', 'pytest-html']
)
