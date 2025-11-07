# appending to a file:
# use "a" mode to add content to the end of an existing file without deleting its content

with open("newfile.txt", "a") as file:
    file.write("This file was just created")