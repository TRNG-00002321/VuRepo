import json

name = input("Enter your name: ")
age = input("Enter your age: ")
city = input("Enter your city: ")

userData = {"name": name, "age": age, "city": city}

with open ('userData.json', 'w') as userDataFile:
    data = json.load(userDataFile)
    print(data)
