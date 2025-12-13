import csv

import pytest
from src.calculator import Calculator

# @pytest.mark.parametrize(
#     "input,output",
#     [
#         (1,2),
#         (2,4),
#         (3,6),
#         (4,8)
#     ]
# )
# def test_double(input, output):
#     calculator = Calculator()
#     assert calculator.double(input) == output

def load_csv_data():
    rows = []
    with open("test_data/double_cases.csv", newline="") as file:
        reader = csv.DictReader(file)
        for row in reader:
            rows.append((int(row["input"]), int(row["output"])))
    return rows

@pytest.mark.parametrize(
    "input,output",
    load_csv_data()
)
def test_double(input, output):
    calculator = Calculator()
    assert calculator.double(input) == output
