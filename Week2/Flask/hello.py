from flask import Flask

app = Flask(__name__)

@app.route('/')
def hello_world(): # these funcions are view function
    return "Hello World!"
@app.route('/hello')
def hello_again():
    return "Hello Again"

@app.route('/hello/<name>')
def hiname(name):
    return "Hi, %s!" %name.upper()

@app.route('/square/<int:n>')
def square(n):
    return str(n**2)

@app.route('/circle/<float:radius>')
def circle(radius):
    return str(radius*3.14)

@app.route('/sum/<int:n>/<int:m>')
def sum(n,m):
    return str(n+m)

def hithere():
    return "hi there"

app.add_url_rule('/hi', view_func=hithere)

if __name__ == '__main__':
    app.run(debug=True)
