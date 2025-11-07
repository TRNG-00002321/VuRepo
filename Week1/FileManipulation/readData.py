import json

with open('userData.json', 'r') as data_file:
    userData = json.load(data_file)
    print(userData)
