from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from argparse import Namespace
from prophecy.test import BaseTestCase
from prophecy.test.utils import *
from python_external_git_pipeline.graph.OrderBy_1 import *
import python_external_git_pipeline.config.ConfigStore as ConfigStore


class OrderBy_1Test(BaseTestCase):

    def test_unit_test_0(self):
        dfIn0 = createDfFromResourceFiles(
            self.spark,
            'test/resources/data/python_external_git_pipeline/graph/OrderBy_1/in0/schema.json',
            'test/resources/data/python_external_git_pipeline/graph/OrderBy_1/in0/data/test_unit_test_0.json',
            'in0'
        )
        dfOut = createDfFromResourceFiles(
            self.spark,
            'test/resources/data/python_external_git_pipeline/graph/OrderBy_1/out/schema.json',
            'test/resources/data/python_external_git_pipeline/graph/OrderBy_1/out/data/test_unit_test_0.json',
            'out'
        )
        dfOutComputed = OrderBy_1(self.spark, dfIn0)
        assertDFEquals(
            dfOut.select("c- short", "c  - int"),
            dfOutComputed.select("c- short", "c  - int"),
            self.maxUnequalRowsToShow
        )

    def setUp(self):
        BaseTestCase.setUp(self)
        import os
        fabricName = os.environ['FABRIC_NAME']
        ConfigStore.Utils.initializeFromArgs(
            self.spark,
            Namespace(file = f"configs/resources/config/{fabricName}.json", config = None)
        )
