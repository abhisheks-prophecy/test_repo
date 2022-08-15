from setuptools import setup, find_packages
setup(
    name = 'Workflow-Automated-GITHUB-1660231420901',
    version = '1.0',
    packages = find_packages(include = ('workflowautomatedgithub*', )),
    description = 'workflow',
    install_requires = [
'prophecy-libs==1.3.1'],
    entry_points = {
'console_scripts' : [
'main = workflowautomatedgithub.pipeline:main', ], },
    extras_require = {
'test' : ['pytest', 'pytest-html'], }
)
