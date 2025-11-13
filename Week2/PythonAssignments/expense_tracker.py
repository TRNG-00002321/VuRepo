import sqlite3
from flask import flash, redirect, render_template, request, Flask

app = Flask(__name__, template_folder='templates')
DB_name = 'expenses.db'

def get_db_connection():
    conn = sqlite3.connect(DB_name)
    conn.row_factory = sqlite3.Row
    return conn

def init_db():
    conn = get_db_connection()
    cursor = conn.cursor()
    cursor.execute('''
        CREATE TABLE IF NOT EXISTS expenses (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            date TEXT NOT NULL,
            amount INTEGER NOT NULL,
            category TEXT NOT NULL,
            description TEXT
        )
    ''')
    conn.commit()
    conn.close()

init_db()

@app.route('/')
def home():
    expensesTable = {}
    conn = get_db_connection()
    cursor = conn.cursor()
    cursor.execute("SELECT * FROM expenses")
    rows = cursor.fetchall()
    for row in rows:
        expensesTable[row['id']] = {
            'date': row['date'],
            'amount': row['amount'],
            'category': row['category'],
            'description': row['description']
        }
    conn.close()
    return render_template('index.html', expenses=expensesTable)

@app.route('/add', methods=['POST'])
def add_expense():
    conn = get_db_connection()
    cursor = conn.cursor()
    date = request.form['date']
    amount = int(request.form['amount'])
    category = request.form['category']
    description = request.form['description']
    cursor.execute(
        'INSERT INTO expenses (date, amount, category, description) VALUES (?, ?, ?, ?)',
        (date, amount, category, description)
    )
    conn.commit()
    conn.close()
    return redirect('/')

@app.route('/update/<int:idNum>', methods=['GET', 'POST'])
def update_expense(idNum):
    conn = get_db_connection()
    if request.method == 'POST':
        # Process the form submission
        date = request.form['date']
        amount = int(request.form['amount'])
        category = request.form['category']
        description = request.form['description']

        conn.execute(
            'UPDATE expenses SET date=?, amount=?, category=?, description=? WHERE id=?',
            (date, amount, category, description, idNum)
        )
        conn.commit()
        conn.close()
        return redirect('/')

    else:
        row = conn.execute('SELECT * FROM expenses WHERE id=?', (idNum,)).fetchone()
        conn.close()
        expense = dict(row)
        return render_template('update.html', expense=expense)

@app.route('/delete/<int:idNum>', methods=['POST'])
def delete_expense(idNum):
    conn = get_db_connection()
    conn.execute("DELETE FROM expenses WHERE id=?", (idNum,))
    conn.commit()
    conn.close()
    return redirect('/')

if __name__ == '__main__':
    app.run(debug=True)
