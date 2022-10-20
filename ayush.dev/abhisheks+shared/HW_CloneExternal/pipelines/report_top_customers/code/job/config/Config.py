from prophecy.config import ConfigBase


class Config(ConfigBase):

    def __init__(self, a: int=None, b: bool=None):
        self.spark = None
        self.update(a, b)

    def update(self, a: int=67, b: bool=True):
        self.a = self.get_int_value(a)
        self.b = self.get_bool_value(b)
        pass
