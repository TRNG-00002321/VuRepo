import unittest
from unittest.mock import Mock

def greet(func):
    return "Hello, " + func()

class TestMostBasic(unittest.TestCase):
    def test_mock_return_value_and_asser_call(self):
        fake_func = Mock(return_value="World")
        result = greet(fake_func)

        # behavior check
        self.assertEqual(result, "Hello, World")

        # validation with called once
        fake_func.assert_called_once()

        # validation: called with no arguments
        fake_func.assert_called_once_with()

if __name__ == '__main__':
    unittest.main()