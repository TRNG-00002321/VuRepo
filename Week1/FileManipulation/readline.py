
with open("example.txt", "r") as file:
    line1 = file.readlines()
    line2 = file.readlines()
    print(line1, line2)