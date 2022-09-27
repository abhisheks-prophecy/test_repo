from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from argparse import Namespace
from prophecy.test import BaseTestCase
from prophecy.test.utils import *
from pythoninsideprojectdatasetsonly.graph.Reformat_1 import *
import pythoninsideprojectdatasetsonly.config.ConfigStore as ConfigStore


class Reformat_1Test(BaseTestCase):

    def test_unit_test_0(self):
        dfIn0 = createDfFromResourceFiles(
            self.spark,
            'test/resources/data/pythoninsideprojectdatasetsonly/graph/Reformat_1/in0/schema.json',
            'test/resources/data/pythoninsideprojectdatasetsonly/graph/Reformat_1/in0/data/test_unit_test_0.json',
            'in0'
        )
        dfOut = createDfFromResourceFiles(
            self.spark,
            'test/resources/data/pythoninsideprojectdatasetsonly/graph/Reformat_1/out/schema.json',
            'test/resources/data/pythoninsideprojectdatasetsonly/graph/Reformat_1/out/data/test_unit_test_0.json',
            'out'
        )
        dfOutComputed = Reformat_1(self.spark, dfIn0)
        assertDFEquals(
            dfOut.select("customer_id", "first_name"),
            dfOutComputed.select("customer_id", "first_name"),
            self.maxUnequalRowsToShow
        )

    def test_unit_test_1(self):
        dfIn0 = createDfFromResourceFiles(
            self.spark,
            'test/resources/data/pythoninsideprojectdatasetsonly/graph/Reformat_1/in0/schema.json',
            'test/resources/data/pythoninsideprojectdatasetsonly/graph/Reformat_1/in0/data/test_unit_test_1.json',
            'in0'
        )
        dfOutComputed = Reformat_1(self.spark, dfIn0)
        assertPredicates(
            "out",
            dfOutComputed,
            list(zip([~ col("customer_id").like("%a%"), ~ col("first_name").like("%1%")], ["p1", "p1"]))
        )

    def setUp(self):
        BaseTestCase.setUp(self)
        import os
        fabricName = os.environ['FABRIC_NAME']
        ConfigStore.Utils.initializeFromArgs(
            self.spark,
            Namespace(file = f"configs/resources/config/{fabricName}.json", config = None)
        )
