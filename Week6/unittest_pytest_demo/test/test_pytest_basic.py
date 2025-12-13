import pytest
from src.calculator import Calculator

@pytest.fixture
def calculator():
    return Calculator()

def test_calculator(calculator):
    #calculator = Calculator()
    result = calculator.add(1, 2)
    assert result == 3

def test_calculator_even(calculator):
    #calculator = Calculator()
    assert calculator.is_even(3) is False
    assert calculator.is_even(4) is True

def test_divide_by_zero(calculator):
    #calculator = Calculator()
    with pytest.raises(ZeroDivisionError):
        calculator.div(3,0)

def test_divide_by_zero_context(calculator):
    #calculator = Calculator()
    with pytest.raises(ZeroDivisionError) as context:
        calculator.div(3,0)
    assert str(context.value) == 'division by zero'



