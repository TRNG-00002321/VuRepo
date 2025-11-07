# Nested dictionary of employees
employees = {
    "emp1": {
        "name": "Alice",
        "age": 28,
        "salary": 55000
    },
    "emp2": {
        "name": "Bob",
        "age": 34,
        "salary": 62000
    },
    "emp3": {
        "name": "Charlie",
        "age": 25,
        "salary": 48000
    }
}

def raiseSalary(employee):
    for key, value in employee.items():
        for key1, value1 in value.items():
            if key1 == "salary":
                value[key1]=int(value1*1.1)

raiseSalary(employees)
print(employees)