from setuptools import setup, find_packages

setup(
    name='Workflow-Automated-GITHUB-1654086151641',
    version='1.0',
    packages=find_packages(include=('job*',)),
    description='Workflow-Automated-GITHUB-1654086151641',
    install_requires=[
        'pyhocon==0.3.59',
        'prophecy-libs==0.1.6'
    ],
    entry_points={
        'console_scripts': [
            'main = job.pipeline:main',
        ],
    },
    tests_require=['pytest', 'pytest-html']
)
