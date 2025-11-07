
with open('example.txt', 'r') as data_file:
    data = data_file.read()

with open("example2.txt", "w") as data_file:
    data_file.write(data)

print("Successfully copy content")