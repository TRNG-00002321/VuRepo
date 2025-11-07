# writing multiple lines
# you can write multiple lines using writelines()
# which takes a list of strings:


lines = ["Line 1\n", "Line 2\n", "Line 3\n"]
with open("multilines.txt", "w") as file:
    file.writelines(lines)