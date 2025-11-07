
celsius_temps = [0, 10, 20, 30]
def conversion(celsius_temp):
    fahrenheit_temps = list(map(lambda x: (x * 9/5) + 32, celsius_temps))
    print(fahrenheit_temps)
conversion(celsius_temps)

names = ["alice", "bob", "charlie"]
def capitalize(name):
    result = list(map(lambda x: x.capitalize(), name))
    print(result)
capitalize(names)

list1 = [1, 2, 3]
list2 = [4, 5, 6]
def combinations(list1, list2):
    combine = list(map(lambda x,y: x+y, list1, list2))
    print(combine)
combinations(list1, list2)

first_names = ["John", "Jane"]
last_names = ["Doe", "Smith"]
def concatination(first_name, last_name):
    concat = list(map(lambda x, y: x + " " + y, first_name, last_name))
    print(concat)
concatination(first_names, last_names)

words = ["apple", "banana", "cherry"]
def stringLength(s):
    length = list(map(lambda x: len(x), s))
    print(length)
stringLength(words)