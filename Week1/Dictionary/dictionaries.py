
countries = {
    "United Kingdom": "London",
    "VietNam": "Ha Noi",
    "Thailand": "Bangkok",
    "USA": "Washington",
    "China": "Beijing",
}

def getCapital(countryList, country):
    for key, value in countryList.items():
        if key == country:
            print(f"The capital of {country} is {value}")

userInput = input("Please enter your country: ")
getCapital(countries, userInput)


student_scores = {
    "Alice": 85,
    "Bob": 92,
    "Charlie": 78,
    "David": 90
}

def highestScore(studentList):
    topScore = 0
    topStudent = ""
    for key, value in studentList.items():
        if topScore < value:
            topScore = value
            topStudent = key
    print(f"The highest score of {topStudent} is {topScore}")
highestScore(student_scores)

