from functools import reduce

words = ["apple", "banana", "cat", "dog", "elephant", "frog"]
wordsFiltered = list(filter(lambda x: len(x)>5, words))
print(wordsFiltered)

students = [
    {"name": "Alice", "grade": 85},
    {"name": "Bob", "grade": 92},
    {"name": "Charlie", "grade": 78},
    {"name": "David", "grade": 95}
]
newStudents = list(filter(lambda x: x["grade"] > 90, students))
print(newStudents)

words = ["Python", "is", "awesome", "!"]
newWord = reduce(lambda x, y: x + " " + y, words)
print(newWord)

numbers = [10, 3, 25, 7, 18]
highest = reduce(lambda x, y: x if x > y else y, numbers)
print(highest)

list_of_lists = [[1, 2], [3, 4], [5, 6]]
reducedList = list(reduce(lambda x, y: x + y, list_of_lists))
print(reducedList)



