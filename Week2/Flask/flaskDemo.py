from flask import Flask, redirect, url_for

app = Flask(__name__)

@app.route('/admin/<admin>')
def hello_admin(admin):
    return "Hello, Admin! %s" %admin.upper()

@app.route('/guest/<name>')
def hello_guess(name):
    return "Hello, guess!, %s!" %name.upper()

@app.route('/user/<name>')
def hello_user(name):
    if name == 'admin':
        return redirect(url_for('hello_admin', admin=name))
    else:
        return redirect(url_for('hello_guess', guess=name))

if __name__ == '__main__':
    app.run(debug=True)