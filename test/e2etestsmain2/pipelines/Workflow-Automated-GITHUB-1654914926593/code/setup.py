from setuptools import setup, find_packages

setup(
    name='Workflow-Automated-GITHUB-1654914926593',
    version='1.0',
    packages=find_packages(include=('job*',)),
    description='Workflow-Automated-GITHUB-1654914926593',
    install_requires=[
        'prophecy-libs==1.1.1'
    ],
    entry_points={
        'console_scripts': [
            'main = job.pipeline:main',
        ],
    },
    tests_require=['pytest', 'pytest-html']
)
