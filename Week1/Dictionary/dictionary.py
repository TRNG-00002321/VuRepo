#Given an array arr[], find the first repeating element.
#The element should occur more than once and the index of its first occurrence should be the smallest.

def firstRepeat(intList):
    indexDict = {}
    minIndex = len(intList)
    for i, num in enumerate(intList):
        if num in indexDict:
            minIndex = min(minIndex, indexDict[num])
        else:
            indexDict[num] = i
    if minIndex == len(intList):
        return -1
    else:
        return minIndex

intList = [1, 5, 3, 4, 3, 5, 6]
print("Index of first repeating element:", firstRepeat(intList))

