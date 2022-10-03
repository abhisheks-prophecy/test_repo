from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from argparse import Namespace
from prophecy.test import BaseTestCase
from prophecy.test.utils import *
from pythoninsideprojectdatasetsonly.graph.OrderBy_1 import *
import pythoninsideprojectdatasetsonly.config.ConfigStore as ConfigStore


class OrderBy_1Test(BaseTestCase):

    def test_unit_test_0(self):
        dfIn0 = createDfFromResourceFiles(
            self.spark,
            'test/resources/data/pythoninsideprojectdatasetsonly/graph/OrderBy_1/in0/schema.json',
            'test/resources/data/pythoninsideprojectdatasetsonly/graph/OrderBy_1/in0/data/test_unit_test_0.json',
            'in0'
        )
        dfOut = createDfFromResourceFiles(
            self.spark,
            'test/resources/data/pythoninsideprojectdatasetsonly/graph/OrderBy_1/out/schema.json',
            'test/resources/data/pythoninsideprojectdatasetsonly/graph/OrderBy_1/out/data/test_unit_test_0.json',
            'out'
        )
        dfOutComputed = OrderBy_1(self.spark, dfIn0)
        assertDFEquals(
            dfOut.select(
              "customer_id",
              "first_name",
              "last_name",
              "phone",
              "email",
              "country_code",
              "account_open_date",
              "account_flags",
              "c_lookup",
              "c_config"
            ),
            dfOutComputed.select(
              "customer_id",
              "first_name",
              "last_name",
              "phone",
              "email",
              "country_code",
              "account_open_date",
              "account_flags",
              "c_lookup",
              "c_config"
            ),
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
        dfgraph_Lookup_1 = createDfFromResourceFiles(
            self.spark,
            'test/resources/data/pythoninsideprojectdatasetsonly/graph/Lookup_1/schema.json',
            'test/resources/data/pythoninsideprojectdatasetsonly/graph/Lookup_1/data.json',
            "in0"
        )
        from pythoninsideprojectdatasetsonly.graph.Lookup_1 import Lookup_1
        Lookup_1(self.spark, dfgraph_Lookup_1)
