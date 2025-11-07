# create a list of 4 or 5 numbers
# 12345, calculate and print their square

num = [1,2,3,4,5]

#for i in num:
    #print(i*i)

square_numbers = list(map(lambda x: x**2, num))
print(square_numbers)