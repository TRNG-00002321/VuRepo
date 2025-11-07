# create a list of 1 to 10, calculate and display the sum of number of the list
from functools import reduce

num = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

result = reduce(lambda x, y: x + y, num)
print(result)

