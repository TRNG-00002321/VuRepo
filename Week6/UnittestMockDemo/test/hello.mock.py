from unittest.mock import Mock

# creating a mock
weather_api = Mock()

# configuring the mock to return a value
weather_api.get_weather.return_value = 25

# use a mock
temp = weather_api.get_temperature('Plano')

# you can assert the other attributes as well
# verifying / asserting the method was called
weather_api.get_temperature.assert_called_with('Plano')