# r is for read, which is the default mode
# w is the create or override mode
# a is the append mode, write without erased the exist file
# x which is for create, but fails if the file already exist
# b which is binary mode
# t is the text mode

file = open("example.txt", "r") # in this case open method take in 2 parameters
content = file.read()
print(content)
file.close()


