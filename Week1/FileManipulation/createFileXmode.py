# creating a new file use "x" mode to create a new file
# if the file alreay exist, it raises a fileExistError

try:
    with open("newFile.txt", "x") as file:
        file.write("This file was just created")
except FileExistsError:
    print("File already exists")