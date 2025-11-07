from functools import reduce

fruits = ["apple", "banana", "cherry"]
x = 50

upper = list(map(lambda x: x.upper(), fruits))
print(upper)

y = lambda x: x * x
print(y(x))

num = [1,2,3,4]
result = reduce(lambda x, y: x * y, num)
print(result)

result1 = list(filter(lambda x: x % 2 == 0, num))
print(result1)

result2 = list(map(lambda x: x * x, num))
print(result2)