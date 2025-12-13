# conftest.py
import json
import pytest
from pathlib import Path


@pytest.fixture(scope="session")
def test_data():
    """Load all test data from JSON file."""
    data_path = Path(__file__).parent / "test_data" / "calculator_tests.json"
    with open(data_path) as f:
        return json.load(f)


def load_test_cases(filename, key):
    """Helper function to load specific test cases."""
    data_path = Path(__file__).parent / "test_data" / filename
    with open(data_path) as f:
        data = json.load(f)
    return data.get(key, [])