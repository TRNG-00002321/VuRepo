#You are given an array arr[] of size n. You have to insert all elements of arr[]
# into a set and return that set .You are also given a interger x.
#If x is found in set then erase it from set and print "erased x", otherwise, print "not found".

intList = [1, 2, 3, 5, 5, 6, 7, 3, 9, 10]
x = 5
size = len(intList)
intSet = set(intList)
print(intSet)

if x in intSet:
    intSet.remove(x)
    print(f"Erased {x}")
else:
    print(f"Not found")
print(f"Updated Set: {intSet}")
