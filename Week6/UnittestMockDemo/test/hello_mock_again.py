from unittest.mock import Mock

mock = Mock()

mock.api.return_value = {'id':1, 'name': 'Vu'}

# calls the api
print(mock.api)

# calls api function which returns the value
print(mock.api())