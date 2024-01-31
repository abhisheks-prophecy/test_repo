from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from argparse import Namespace
from prophecy.test import BaseTestCase
from prophecy.test.utils import *
from py_del_git_pipeline1.graph.Script_2 import *
import py_del_git_pipeline1.config.ConfigStore as ConfigStore


class Script_2Test(BaseTestCase):

    def test_unit_test_0(self):
        dfIn0 = createDfFromResourceFiles(
            self.spark,
            'test/resources/data/py_del_git_pipeline1/graph/Script_2/in0/schema.json',
            'test/resources/data/py_del_git_pipeline1/graph/Script_2/in0/data/test_unit_test_0.json',
            'in0'
        )
        dfOut0 = createDfFromResourceFiles(
            self.spark,
            'test/resources/data/py_del_git_pipeline1/graph/Script_2/out0/schema.json',
            'test/resources/data/py_del_git_pipeline1/graph/Script_2/out0/data/test_unit_test_0.json',
            'out0'
        )
        dfOut0Computed = Script_2(self.spark, dfIn0)
        assertDFEquals(dfOut0.select("a"), dfOut0Computed.select("a"), self.maxUnequalRowsToShow)

    def setUp(self):
        BaseTestCase.setUp(self)
        import os
        fabricName = os.environ['FABRIC_NAME']
        ConfigStore.Utils.initializeFromArgs(
            self.spark,
            Namespace(file = f"configs/resources/config/{fabricName}.json", config = None)
        )
