# Write a Python program to check whether a given key already exists in a dictionary.
dict = {'Name' : 'Ram', 'Age' : 23}

def keyChecker(dictionary, key):
    if key in dictionary:
        print("Key is available in the dictionary")

keyChecker(dict, 'Name')