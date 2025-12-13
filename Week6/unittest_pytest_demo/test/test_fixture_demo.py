import pytest

@pytest.fixture
def database_connection():
    # SetUp
    print("Establish database connection...")
    connection = "simulated_db_connection"
    yield connection
    # TearDown
    print("Closing database connection...")
    # connection.close() # replace with actual close logic

def test_database_connection(database_connection):
    print(f"Using database connection: {database_connection}")
    assert database_connection == "simulated_db_connection"

def test_conftest_user(sample_data):
    assert sample_data["name"] == "Alex"
    assert sample_data["age"] == 22