from prophecy.config import ConfigBase


class Config(ConfigBase):

    def __init__(self, c_config1: str=None):
        self.spark = None
        self.update(c_config1)

    def update(self, c_config1: str="main"):
        self.c_config1 = c_config1
        pass
