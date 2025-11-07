import json

my_data = {
    "name": "Alice",
    "age": 20,
    "city": "New York",
    "isStudent": False,
    "courses": ["Math", "Science"]
}

# open a file in write mode ('w'). If the file doesn't exist, it will be created
# if it exists, its content will be overwritten.
with open("data.json", "w") as file:
    # Dump the python data into the file in JSON format
    json.dump(my_data, file, indent=4) # 'indent=4' makes the output human-readable