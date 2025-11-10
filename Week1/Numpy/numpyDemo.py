import numpy as np

arr = np.array([1, 2, 3, 4])
print(arr)
print(type(arr))

arr8 = np.array(42)
print(arr8)

#2d array
arr6 = np.array([[1, 2, 3], [4, 5, 6]])  # Must assign back to arr6
print(arr6)

# ndim help returns an integer of how many dimensions the array have
print(arr.ndim)
print(arr6.ndim)


# ndmin used to define the number of dimension
arr1 = np.array([1, 2, 3, 4], ndmin=5)
print(arr1)
print('number of dimensions :', arr1.ndim)

# accessing array elements
print(arr6[0])

#accessing 2d array dimension
print(f"second element of 1 row is: {arr6[0,1]}")

# accessing 3d array
arr7 = np.array([[[1, 2, 3], [4, 5, 6]], [[7, 8, 9], [10, 11, 12]]])
print(arr7[0,0,2])

# accessing array from the end
print(f"last element is: {arr[-1]}")

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
newarr2 = newarr.reshape(-1)
print(newarr2)

# array iterating
arr9 = np.array([[[1, 2, 3], [4, 5, 6]], [[7, 8, 9], [10, 11, 12]]])
for x in arr9:
  for y in x:
    for z in y:
      print(z)

arr10 = np.array([1, 2, 3])
arr11 = np.array([4, 5, 6])

# join 2 numpy array
arr12 = np.concatenate((arr10, arr11))
print(arr12)

# splitting array
arr13 = np.split(arr12, 3)
print(arr13)

# search array
x = np.where(arr10==2)
print(x)

arr14 = np.array([3,4,6,1,7,3])
# sorting the array
array15 = np.sort(arr14)
print(array15)

#sorting 2d array
arr16 = np.array([[3, 2, 4], [5, 0, 1]])
print(np.sort(arr16))

# filter numpy array
arr17 = np.array([41, 42, 43, 44])
arr18 = [True, False, True, False]
arr19 = arr17[arr18]
print(arr19)

# filter array
arr20 = np.array([1, 2, 3, 4, 5, 6, 7])
filter_arr = arr20 % 2 == 0
arr21 = arr20[filter_arr]
print(filter_arr)
print(arr21)

