import unittest
from src.calculator import Calculator


class TestCalculator(unittest.TestCase):

    def setUp(self):
        self.calculator = Calculator()

    def test_upper(self):
        self.assertEqual('foo'.upper(), 'FOO')

    def test_isupper(self):
        self.assertTrue('FOO'.isupper())
        self.assertFalse('Foo'.isupper())

    def test_add(self):
        n1 = 1
        n2 = 2
        expected = 3
        result = self.calculator.add(n1, n2)
        self.assertEqual(result, expected)

    def test_is_even(self):
        n1 = 2
        result = self.calculator.is_even(n1)
        self.assertTrue(result)

    def test_division_by_zero_context(self):
        with self.assertRaises(ZeroDivisionError) as context:
            self.calculator.div(1, 0)
        self.assertEqual(str(context.exception), 'division by zero')

    def test_divide_by_zero(self):
        with self.assertRaises(ZeroDivisionError):
            self.calculator.div(1, 0)

    def tearDown(self):
        self.calculator = None
