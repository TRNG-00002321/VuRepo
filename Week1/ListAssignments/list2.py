#You are given a number k and a list arr[] that contains integers.
#You need to return list of numbers that are less than k.

k = 8
intList = [1, 2, 3, 4, 5, 6, 7, 8, 9]
newList = []
for num in intList:
    if num < k:
        newList.append(num)

print(newList)