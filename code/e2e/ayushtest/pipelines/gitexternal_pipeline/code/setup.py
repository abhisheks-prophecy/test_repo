from setuptools import setup, find_packages

setup(
    name='gitexternal_pipeline',
    version='1.0',
    packages=find_packages(include=('job*',)),
    description='gitexternal_pipeline',
    install_requires=[
        'pyhocon==0.3.59',
        'prophecy-libs==0.1.3'
    ],
    entry_points={
        'console_scripts': [
            'main = job.pipeline:main',
        ],
    },
    tests_require=['pytest', 'pytest-html']
)
