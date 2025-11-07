#create a list containing 5 elements, base on this list
#create another list having elements from the previous list containing the character a

fruits = ["apple", "banana", "cherry"]
newList = []

for x in fruits:
    if "a" in x:
        newList.append(x)

print(newList)

fruits = ["apple", "banana", "cherry"]

newList = [x for x in fruits if "a" in x]

print(newList)



