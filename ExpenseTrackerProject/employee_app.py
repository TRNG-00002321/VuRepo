import sqlite3

def get_db():
    conn = sqlite3.connect('expenses.db')
    cursor = conn.cursor()

    cursor.execute('''
    CREATE TABLE IF NOT EXISTS users (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        username TEXT NOT NULL,
        password TEXT NOT NULL,
        role TEXT NOT NULL
    )
    ''')

    cursor.execute('''
    CREATE TABLE IF NOT EXISTS expenses (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        user_id INTEGER NOT NULL,
        amount REAL,
        description TEXT,
        date TEXT,
        FOREIGN KEY(user_id) REFERENCES users(id)
    )
    ''')

    cursor.execute('''
    CREATE TABLE IF NOT EXISTS approvals (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        expense_id INTEGER NOT NULL,
        status TEXT NOT NULL,
        comments TEXT,
        review_date TEXT,
        FOREIGN KEY(expense_id) REFERENCES expenses(id)
    )
    ''')

    conn.commit()
    conn.close()

def seed_users():
    conn = sqlite3.connect('expenses.db')
    cursor = conn.cursor()
    cursor.execute("SELECT * FROM users WHERE username = ?", ("employee1",))
    if cursor.fetchone() is None:
        cursor.execute('''
            INSERT INTO users (username, password, role)
            VALUES (?, ?, ?)
        ''', ("employee1", "employeepass", "employee"))
    conn.commit()
    conn.close()


def login():
    conn = sqlite3.connect('expenses.db')
    cursor = conn.cursor()

    username = input('Enter your username: ').strip()
    password = input('Enter your password: ').strip()

    cursor.execute(
        "SELECT id, role FROM users WHERE username = ? AND password = ?", (username, password)
    )
    result = cursor.fetchone()
    conn.commit()
    conn.close()

    if result is None:
        print('Incorrect username or password.')
        return None

    user_id, role = result

    if role != "employee":
        print('Access denied, only employee can use this app!')
        return None

    print('Successfully logged in!')
    return user_id

def submit_expense(user_id):
    conn = sqlite3.connect('expenses.db')
    cursor = conn.cursor()
    amount = input('Enter your expense amount: ').strip()
    description = input('Enter your expense description: ').strip()
    date = input('Enter your expense date: ').strip()
    cursor.execute(
    "INSERT INTO expenses (user_id, amount, description, date) VALUES (?, ?, ?, ?)", (user_id, amount, description, date)
    )
    conn.commit()
    new_expense_id = cursor.lastrowid
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
            IFNULL(approvals.status, 'pending') AS status
        FROM expenses 
        LEFT JOIN approvals ON approvals.expense_id = expenses.id
        WHERE expenses.user_id = ?
        ORDER BY expenses.date DESC
    '''

    cursor.execute(query, (user_id,))
    rows = cursor.fetchall()
    conn.close()

    print("\n=== My Expenses ===")
    if not rows:
        print('No expenses yet!')

    for expense in rows:
        exp_id, amount, desc, date, status = expense
        print(f"""
        Amount: ${amount}
        Description: {desc}
        Date: {date}
        Status: {status}

""")

def view_pending_expenses(user_id):
    conn = sqlite3.connect('expenses.db')
    cursor = conn.cursor()
    query = '''
        SELECT 
            expenses.id, 
            expenses.amount, 
            expenses.description, 
            expenses.date
        FROM expenses 
        LEFT JOIN approvals ON approvals.expense_id = expenses.id
        WHERE expenses.user_id = ?
            AND (approvals.status IS NULL or approvals.status = 'pending')
        ORDER BY expenses.date DESC
    '''

    cursor.execute(query, (user_id,))
    rows = cursor.fetchall()

    conn.close()

    print("\n=== Pending Expenses ===")
    if not rows:
        print("You have no pending expenses.")
        return

    for exp in rows:
        exp_id, amount, desc, date = exp
        print(f'''
        Expense ID: {exp_id}
        Amount: ${amount}
        Description: {desc}
        Date: {date}
        Status: pending
        
''')
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

    print("\n=== Expense History (Approved/Denied) ===")
    if not rows:
        print("You have no expense history.")
        return
    for expense in rows:
        expense_id, amount, desc, date, status, comments, review_date = expense
        print(f'''
        Expense ID: {expense_id}
        Amount: ${amount}
        Description: {desc}
        Date: {date}
        Status: {status}
        Comments: {comments if comments else 'None'}
        Review Date: {review_date}
''')

def edit_expense(user_id):
    print("\n=== Pending expense (Editable) ===")
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
    print("\n=== Pending expense (Deletable) ===")
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
    print("\nExpense deleted successfully!")

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

def main():
    get_db()
    seed_users()
    user_id = login()
    if user_id:
        employee_menu(user_id)

if __name__ == '__main__':
    main()