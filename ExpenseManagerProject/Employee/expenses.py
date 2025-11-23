import sqlite3
from tabulate import tabulate
from datetime import datetime

def submit_expense(user_id):
    conn = sqlite3.connect('expenses.db')
    cursor = conn.cursor()
    while True:
        try:
            amount = float(input('Enter your expense amount: ').strip())
            if amount <= 0:
                print('Please enter a positive number.')
            else: break
        except ValueError:
            print('Invalid number. Please enter a valid amount.')

    description = input('Enter your expense description: ').strip()
    while True:
        date_input = input("Enter your expense date (YYYY-MM-DD): ").strip()
        try:
            entered_date = datetime.strptime(date_input, "%Y-%m-%d").date()
            today = datetime.today().date()
            if entered_date > today:
                print('Date cannot be in the future. Try again.')
            else: break
        except ValueError:
            print('Invalid date format. Please use YYYY-MM-DD format.')

    status = "pending"
    cursor.execute(
    "INSERT INTO expenses (user_id, amount, description, date) VALUES (?, ?, ?, ?)", (user_id, amount, description, entered_date)
    )

    new_expense_id = cursor.lastrowid
    cursor.execute(
        "INSERT INTO approvals(expense_id, status) VALUES (?, ?)", (new_expense_id, status)
    )
    conn.commit()
    conn.close()
    print('Successfully submitted expense!')
    return new_expense_id

def view_expenses(user_id):
    conn = sqlite3.connect('expenses.db')
    cursor = conn.cursor()
    query = '''
        SELECT 
            expenses.id, 
            expenses.amount, 
            expenses.description, 
            expenses.date,
            approvals.status
        FROM expenses 
        LEFT JOIN approvals ON approvals.expense_id = expenses.id
        WHERE expenses.user_id = ?
        ORDER BY expenses.date DESC
    '''

    cursor.execute(query, (user_id,))
    rows = cursor.fetchall()
    conn.close()
    if not rows:
        print('No expenses yet!')
        return
    formatted_rows = [
        (exp_id, f"${amount}", desc, date, status)
        for exp_id, amount, desc, date, status in rows
    ]
    print(tabulate(formatted_rows, headers=["Expense ID", "Amount", "Description", "Date", "Status"], tablefmt="fancy_grid"))

def view_pending_expenses(user_id):
    conn = sqlite3.connect('expenses.db')
    cursor = conn.cursor()
    query = '''
        SELECT 
            expenses.id, 
            expenses.amount, 
            expenses.description, 
            expenses.date,
            approvals.status
        FROM expenses 
        LEFT JOIN approvals ON approvals.expense_id = expenses.id
        WHERE expenses.user_id = ?
            AND (approvals.status = 'pending')
        ORDER BY expenses.date DESC
    '''

    cursor.execute(query, (user_id,))
    rows = cursor.fetchall()

    conn.close()

    if not rows:
        print("You have no pending expenses.")
        return

    formatted_rows = [
        (exp_id, f"${amount}", desc, date, status)
        for exp_id, amount, desc, date, status in rows
    ]
    print(tabulate(formatted_rows, headers=["Expense ID", "Amount", "Description", "Date", "Status"], tablefmt="fancy_grid"))
    return rows

def view_expense_history(user_id):
    conn = sqlite3.connect('expenses.db')
    cursor = conn.cursor()
    query = '''
        SELECT 
            expenses.id, 
            expenses.amount, 
            expenses.description, 
            expenses.date, 
            approvals.status, 
            approvals.comments,
            approvals.review_date
        FROM expenses 
        LEFT JOIN approvals ON approvals.expense_id = expenses.id
        WHERE expenses.user_id = ?
            AND approvals.status IN ('denied', 'approved')
        ORDER BY expenses.date DESC
    '''

    cursor.execute(query, (user_id,))
    rows = cursor.fetchall()
    conn.close()

    if not rows:
        print("You have no expense history.")
        return

    formatted_rows = [
        (exp_id, f"${amount}", desc, date, status, comments, review_date)
        for exp_id, amount, desc, date, status, comments, review_date in rows
    ]
    print(tabulate(rows, headers=["Expense ID", "Amount", "Description", "Date", "Status", "Comments","Review Date"], tablefmt="fancy_grid"))
    print()

def edit_expense(user_id):
    pending_list = view_pending_expenses(user_id)

    if not pending_list:
        print("No pending expense to edit.")
        return
    try:
        expense_id = int(input("Enter the Expense ID you want to edit: ").strip())
    except ValueError:
        print("Invalid Expense ID.")
        return

    valid_ids = [exp[0] for exp in pending_list]
    if expense_id not in valid_ids:
        print("Error: you can only edit your own pending expenses.")
        return

    print("\nEnter new values (leave blank to cancel):")

    conn = sqlite3.connect('expenses.db')
    cursor = conn.cursor()
    cursor.execute(
        "SELECT amount, description, date FROM expenses WHERE id = ?", (expense_id,)
    )
    old_amount, old_desc, old_date = cursor.fetchone()

    new_amount = input(f"New Amount (old: {old_amount}): ").strip()
    new_desc = input(f"New Description (old: {old_desc}): ").strip()
    new_date = input(f"New Date (old: {old_date}): ").strip()

    if new_amount == "":
        new_amount = old_amount
    if new_desc == "":
        new_desc = old_desc
    if new_date == "":
        new_date = old_date

    cursor.execute('''
        UPDATE expenses 
        SET amount = ?, description = ?, date = ?
        WHERE id = ?
    ''',

                   (new_amount, new_desc, new_date, expense_id))
    conn.commit()
    conn.close()
    print("\nExpense updated successfully!")

def delete_expense(user_id):
    pending_list = view_pending_expenses(user_id)

    if not pending_list:
        print("No pending expense to delete.")
        return
    try:
        expense_id = int(input("Enter the Expense ID you want to delete: ").strip())
    except ValueError:
        print("Invalid Expense ID.")
        return

    valid_ids = [exp[0] for exp in pending_list]
    if expense_id not in valid_ids:
        print("Error: you can only delete your own pending expenses.")
        return

    conn = sqlite3.connect('expenses.db')
    cursor = conn.cursor()
    cursor.execute(
        "DELETE FROM expenses WHERE id = ?", (expense_id,)
    )

    conn.commit()
    conn.close()
    print("Expense deleted successfully!")