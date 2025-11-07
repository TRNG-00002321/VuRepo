# You are given a list arr that contains integers. You need to return average of the non negative integers.
intList = [-12, 8, -7, 6, 12, -9, 14]
average = 0
iterator = 0
for num in intList:
    if num > -1:
        iterator += 1
        average = average + num

average=average//iterator
print(average)
