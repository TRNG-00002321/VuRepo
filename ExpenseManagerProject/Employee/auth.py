import sqlite3

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