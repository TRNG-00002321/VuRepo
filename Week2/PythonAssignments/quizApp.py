# Quiz App
quiz_questions = {
    "Python is a statically typed language.": "False",
    "Lists in Python are mutable.": "True",
    "Tuples in Python can be modified after creation.": "False",
    "The 'def' keyword is used to define a function in Python.": "True",
    "Python uses curly braces {} to define code blocks.": "False",
    "Dictionaries in Python store data as key-value pairs.": "True",
    "Strings in Python are immutable.": "True",
    "Indentation is optional in Python.": "False",
    "The 'lambda' keyword is used to create anonymous functions.": "True",
    "Python was created by Guido van Rossum.": "True"
}
score = 0
print("Quiz questions: ")
for key, value in quiz_questions.items():
    ask = input(f"{key} True/False?: ")
    if ask == value:
        score += 1
        print(f"Correct answer, current score is {score}")
    else:
        print(f"Incorrect answer, current score is {score}")
print(f"End of Quiz, final score is {score}, Nice try!")



