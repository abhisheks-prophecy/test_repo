from setuptools import setup, find_packages
setup(
    name = 'Workflow-Automated-GITHUB-1659006166917',
    version = '1.0',
    packages = find_packages(include = ('workflowautomatedgithub*', )),
    description = 'workflow',
    install_requires = [
'main = prophecy-libs==1.1.14'],
    entry_points = {
'console_scripts' : [
'main = workflowautomatedgithub.pipeline:main', ], },
    extras_require = {
'test' : ['pytest', 'pytest-html'], }
)
