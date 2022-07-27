from setuptools import setup, find_packages

setup(
    name='Workflow-Automated-GITHUB-1654206860848',
    version='1.0',
    packages=find_packages(include=('job*',)),
    description='Workflow-Automated-GITHUB-1654206860848',
    install_requires=[
        'pyhocon==0.3.59',
        'prophecy-libs==1.0.2'
    ],
    entry_points={
        'console_scripts': [
            'main = job.pipeline:main',
        ],
    },
    tests_require=['pytest', 'pytest-html']
)
