import unittest
from unittest.mock import Mock, MagicMock, patch
from src import total

class TotalTest(unittest.TestCase):
    def test_calculate_total(self):
        #total.read = Mock()
        total.read = MagicMock()
        total.read.return_value = [1,2,3]

        result = total.calculate_total('')
        self.assertEqual(result, 6)
        total.read.assert_called_once_with('')

    def test_calculate_test_patch(self):
        with patch('src.total.read') as mock_read:
            mock_read.return_value = [2,3,4]
            result = total.calculate_total('')
            self.assertEqual(result, 9)
            mock_read.assert_called_once_with('')

    @patch('src.total.read')
    def test_calculate_total_patch_decorator(self, mock_read_decorator):
        mock_read_decorator.return_value = [2,3,4]
        result = mock_read_decorator.calculate_total('')

    def multiply_values(self, values):
        result = 1
        for v in values:
            result *= v
        return result

    @patch('src.total.read')
    def test_multiply_values(self, mock_read_decorator):
        mock_read_decorator.return_value = [1,2,3,4]
        with patch('src.total.sum', side_effect=self.multiply_values):
            result = total.calculate_total('')
        self.assertEqual(result, 24)
        mock_read_decorator.assert_called_once_with('')

    # side effect method for handling negative number
    def negative_check_side_effect(self,values):
        if any(v < 0 for v in values):
            return ValueError("Negative values not allowed")
        return sum(values)

    @patch('src.total.read')
    def test_negative_check_side_effect(self, mock_read_decorator):
        mock_read_decorator.return_value = [2,3,4,-3]
        with patch('src.total.sum', side_effect=self.negative_check_side_effect):
            result = total.calculate_total('')
        self.assertIsInstance(result, ValueError)
        self.assertEqual("Negative values not allowed", str(result))
        mock_read_decorator.assert_called_once_with('')
