from prophecy.config import ConfigBase


class Config(ConfigBase):

    def __init__(self, c_string: str=None, c_int: int=None, c_long: int=None):
        self.spark = None
        self.update(c_string, c_int, c_long)

    def update(self, c_string: str="string value", c_int: int=10, c_long: int=13213213):
        self.c_string = c_string
        self.c_int = self.get_int_value(c_int)
        self.c_long = self.get_int_value(c_long)
        pass
