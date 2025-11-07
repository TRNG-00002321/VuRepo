import os
path = os.path.join("example.txt")
with open(path, "r") as file:
    print(file.read())