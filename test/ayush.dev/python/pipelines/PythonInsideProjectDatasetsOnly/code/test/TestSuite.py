import unittest

from test.pythoninsideprojectdatasetsonly.graph.test_Deduplicate_2 import *
from test.pythoninsideprojectdatasetsonly.graph.test_Aggregate_1 import *
from test.pythoninsideprojectdatasetsonly.graph.test_SetOperation_1 import *
from test.pythoninsideprojectdatasetsonly.graph.test_Limit_1 import *
from test.pythoninsideprojectdatasetsonly.graph.test_Filter_1 import *
from test.pythoninsideprojectdatasetsonly.graph.test_Reformat_1 import *
from test.pythoninsideprojectdatasetsonly.graph.test_OrderBy_1 import *
from test.pythoninsideprojectdatasetsonly.graph.test_WindowFunction_1 import *
from test.pythoninsideprojectdatasetsonly.graph.test_SchemaTransform_1 import *

if __name__ == "__main__":
    runner = unittest.TextTestRunner()
    runner.run(unittest.TestSuite())
