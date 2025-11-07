import numpy as np

arr = np.array([1, 2, 3, 4])
print(arr)
print(type(arr))

#2d array

# ndim help returns an integer of how many dimensions the array have

# ndmin used to define the number of dimension
arr1 = np.array([1, 2, 3, 4], ndmin=5)
print(arr1)
print('number of dimensions :', arr1.ndim)

# numpy array indexing

# numpy array slicing

arr2 = np.array([1, 2, 3, 4, 5, 6])
print(arr2[1:5]) # slice from 1 to <5 index
print(arr2[:5]) # slice from beginning to < 5 index
print(arr2[3:]) # slice from 3 to end

# negative slicing to start from the end

arr3 = np.array([1, 2, 3, 4, 5, 6, 7])
print(arr3[-3:-1])
print(arr3[1:5:2])

# slicing 2D arrays

arr4 = np.array([[1, 2, 3, 4],
                 [8, 9, 10, 11]])
print(arr4[1,1:4])

# numpy data types
# i - integer
# b - bool
# c - complex float
# ...

# numpy array shape and reshaping
print(arr4.shape)

# reshaping can change the shape of an array
arr5 = np.array([1,2,3,4,5,6,7,8,9,10,11,12])
newarr = arr5.reshape(3,4)
print(newarr)

# the revert of reshape is flatten by using reshape(-1)
