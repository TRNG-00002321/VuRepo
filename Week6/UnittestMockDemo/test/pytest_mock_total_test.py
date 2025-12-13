import pytest
from pytest_mock import mocker
from src import total


def test_calculate_total(mocker):
    total.read = mocker.Mock()
    total.read.return_value = [1, 2, 3]

    result = total.calculate_total('')

    assert result == 6
    total.read.assert_called_once_with('')

def test_calculate_total_patch(mocker):
    mock_read = mocker.patch('src.total.read')
    mock_read.return_value = [1, 2, 3]
    result = total.calculate_total('')
    assert result == 6
    mock_read.assert_called_once_with('')

# def test_calculate_total_patch(mocker):
#     mocker.patch('src.total.read', return_value=[2, 3, 4])
#
#     result = total.calculate_total('')
#     assert result == 9
#     total.read.assert_called_once_with('')

def multiply_values(values):
    result = 1
    for v in values:
        result *= v
    return result

def test_multiply_values(mocker):
    mocker.patch('src.total.read', return_value=[1, 2, 3, 4])
    mocker.patch('src.total.sum', side_effect=multiply_values)

    result = total.calculate_total('')

    assert result == 24

def negative_check_side_effect(values):
    if any(v < 0 for v in values):
        return ValueError("Negative values not allowed")
    return sum(values)


def test_negative_check_side_effect(mocker):
    mocker.patch('src.total.read', return_value=[2, 3, 4, -3])
    mocker.patch('src.total.sum', side_effect=negative_check_side_effect)

    result = total.calculate_total('')

    assert isinstance(result, ValueError)
    assert str(result) == "Negative values not allowed"