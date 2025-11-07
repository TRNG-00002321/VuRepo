#write a program to input 2 number calculate and display the division


def divide(a,b):
    try:
        val = a//b
    except:
        print("Can't divide by zero")
    else:
        return val


try:
        x = int(input("Enter a number: "))
        y = int(input("Enter another number: "))
except:
    print("Invalid input")
else:
    print(divide(x,y))
