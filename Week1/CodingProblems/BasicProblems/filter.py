# create a list of 1 to 10, from that list create a list of even numbers

x = [1,2,3,4,5,6,7,8,9,10]

even_number = list(filter(lambda x: x % 2 == 0, x))
print(even_number)