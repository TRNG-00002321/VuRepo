name = ["John", "Michael", "David"]
age = [25, 28, 30]

zipped = list(zip(name, age))
print((zipped))

unzipped_names, unzipped_age = zip(*zipped)
print(unzipped_names)
print(unzipped_age)