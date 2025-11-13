from flask import Flask, render_template, request, redirect, url_for
import json

app = Flask(__name__, template_folder='templates')

with open('projects.json') as f:
    projectsLoad = json.load(f)
@app.route('/')
def index():
    return render_template("home.html")

@app.route('/contact')
def contact():
    return render_template('contact.html')

@app.route('/projects')
def projects():
    return render_template('projects.html', projects=projectsLoad)

if __name__ == '__main__':
    app.run(debug=True)