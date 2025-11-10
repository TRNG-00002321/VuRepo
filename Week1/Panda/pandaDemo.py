import pandas as pd

# panda dataframe
mydataset = {
    "cars": ["BMW", "Volvo","Ford"],
    "passings": [3,7,2]
}

myvar = pd.DataFrame(mydataset)
print(myvar)

# panda series
a = [ 1,7,2]
myvar1 =pd.Series(a)
print(myvar1)
print(myvar1[0])

# create labels
myvar2 =pd.Series(a, index = ["x", "y", "z"])
print(myvar2)

# key/value objects as series
calories = {"day1":420,"day2":380,"day3":390}
myvar3 =pd.Series(calories)
print(myvar3)

# panda dataframes: a 2 dimensional data structure, like a 2 dimensional array, or a table with rows and columns
data = {
    "calories":[420,380,390],
    "duration":[50,40,45]
}
df = pd.DataFrame(data)
print(df) #key becomes indexes (label)

# to locate row, we use loc
print(df.loc[0])

# named indexes
df = pd.DataFrame(data, index = ["day1","day2","day3"])
print(df)

# pandas read CSV file
pd.options.display.max_rows = 10
df = pd.read_csv('data.csv')
#print(df.to_string())
print(df)

# pand read JSON filex
df =pd.read_json('data.json')
print(df.to_string())

# to view the data use methods like head or tail
print(df.head(10))