import sqlite3

def get_db():
    conn = sqlite3.connect('expenses.db')
    cursor = conn.cursor()

    cursor.execute('''
    CREATE TABLE IF NOT EXISTS users (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        name TEXT NOT NULL,
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
        reviewer_id INTEGER,
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
    cursor.execute("SELECT * FROM users WHERE username = ?", ("employee2",))
    if cursor.fetchone() is None:
        cursor.execute('''
            INSERT INTO users (name, username, password, role)
            VALUES (?, ?, ?, ?)
        ''', ("John", "employee2", "employeepass", "employee"))
    conn.commit()
    conn.close()