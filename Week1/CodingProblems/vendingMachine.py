import sys

drinks = [("water", 1.0),("coffee", 2.0),("milk", 3.0)]

print("Menu")
for i, drink in enumerate(drinks):
    print(f"{i+1}. {drink[0]} - {drink[1]}")


option = int(input("Enter your choice: "))
if option <1 or option > 3:
    print("Invalid option")
    sys.exit()
else:
    selected_drink = drinks[option-1]
    price = selected_drink[1]
    print(f"You selected {selected_drink[0]}")
    quarters = int(input("How many quarters? "))
    dimes = int(input("How many dimes? "))
    nickles = int(input("How many nickles? "))
    pennies = int(input("How many pennies? "))
    balance = quarters*.25 + dimes*.10 +nickles*.05 + pennies*0.01
    print(f"Your balance is {balance:.2f}")
    if balance < price:
        print("Sorry, you don't have enough money")
        sys.exit()
    else:
        change = balance - price
        print(f"Purchased {selected_drink[0]}, Your change is {change:.2f}")
