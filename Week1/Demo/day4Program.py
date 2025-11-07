import sys

drinks = [("water",1.0),("cola",1.50),("gatorade", 2.0)]


print("Vending Menu: ")
for i, drink in enumerate(drinks,1):
    print(f"{i}. {drink[0]} is {drink[1]}")

option = int(input("Which drink do you want?: "))

if option >3 or option <1:
    print("Invalid option")
    sys.exit()
else:

    selected_drink = drinks[option-1]
    price = selected_drink[1]
    print(f"Selected drink:", selected_drink[0])

    quarters = int(input("Number of quarters inserted: "))
    dimes = int(input("Number of dimes inserted: "))
    nickles = int(input("Number of nickles inserted: "))
    pennies = int(input("Number of pennies inserted: "))
    balance = quarters*0.25 + dimes*0.10 + nickles*0.05 + pennies*0.01
    print(f"Your balance is: ${balance:.2f}")

    if balance >= price:
        balance = balance - price
        print(f"Purchased, remaining balance: ${balance:.2f}")
    else:
        print("Not enough money. Try again")
        sys.exit()

