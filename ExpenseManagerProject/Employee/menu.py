from expenses import (
    submit_expense,
    view_expenses,
    view_pending_expenses,
    view_expense_history,
    edit_expense,
    delete_expense
)

def employee_menu(user_id):
    while True:
        print("\n=== Employee Menu ===")
        print("1. Submit Expense")
        print("2. View All Expenses")
        print("3. View Pending Expenses")
        print("4. View Expense History")
        print("5. Edit Pending Expense")
        print("6. Delete Pending Expense")
        print("7. Logout")

        choice = input("Enter choice: ").strip()
        print()
        if choice == "1":
            submit_expense(user_id)
        elif choice == "2":
            view_expenses(user_id)
        elif choice == "3":
            view_pending_expenses(user_id)
        elif choice == "4":
            view_expense_history(user_id)
        elif choice == "5":
            edit_expense(user_id)
        elif choice == "6":
            delete_expense(user_id)
        elif choice == "7":
            print("Logging out...")
            break
        else:
            print("Invalid choice. Try again.")