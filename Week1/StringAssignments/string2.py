#Given a string s, you need to check if it is palindrome or not.
#A palidrome is a string that reads the same from front and back.

s = "Level"
v = s.lower()
reverse =""
for char in v:
    reverse = char + reverse

if(v==reverse):
    print("Palindrome")
else:
    print("Not Palindrome")