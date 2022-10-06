from prophecy.config import ConfigBase


class Config(ConfigBase):

    def __init__(self, a: int=None):
        self.spark = None
        self.update(a)

    def update(self, a: int=7):
        self.a = self.get_int_value(a)
        pass
