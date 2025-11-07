# reading in chunk: useful for large files:

with open("example.txt") as file:
    while chunk := file.read(1024): # read 1024 characters
        print(chunk)