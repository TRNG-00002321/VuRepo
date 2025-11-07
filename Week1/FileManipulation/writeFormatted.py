#write with string foratting
# you can use f-strings or .format()
# to dynamically write content:

name = "Alice"
score = 95

with open("report.txt", "w") as file:
    file.write(f"Student: {name}, Score: {score}\n")