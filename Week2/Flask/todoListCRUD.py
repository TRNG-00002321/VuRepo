# To-Do List Manager: Create a program to add,
# view, mark as complete, and delete tasks from a list/dictionary,
# potentially saving the list/dictionary to a file.
# Please use the following as well while writing code: Functions, Modules (Optional), Imports (Optional)
from flask import Flask, render_template, request, redirect, url_for
import json
app = Flask(__name__, template_folder='templates')

class TodoList():
    def __init__(self):
        self.tasks = {}

    def addTask(self,task):
        if task in self.tasks:
            print("already added")
        else:
            self.tasks[task] = "not done"

    def markDone(self,task):
        if task in self.tasks:
            self.tasks[task] = "done"
            print(f"Task {task} marked done")
        else:
            print("Task not found")

    def removeTask(self,task):
        if task in self.tasks:
            del self.tasks[task]
            print("Removed task")
        else:
            print("Task not found")

    def printTasks(self):
        for i,task in enumerate(self.tasks,1):
            print(f"Task {i}: {task} is {self.tasks[task]}")

    def readFromFile(self,filename):
        try:
            with open(filename, "r") as file:
                data = json.load(file)
                self.tasks = data
        except FileNotFoundError:
            print("File not found")

    def pasteOut(self, filename):
        with open(filename, "w") as f:
            json.dump(self.tasks, f)

tdo = TodoList()
@app.route('/')
def index():
    tdo.readFromFile("todoList.json")
    return render_template('todolist.html', tasks=tdo.tasks)
@app.route('/add', methods=['POST'])
def addTask():
    task = request.form['todo']
    tdo.tasks[task] = "not done"
    tdo.pasteOut("todoList.json")
    return redirect(url_for('index'))

@app.route('/update', methods=['POST'])
def updateTask():
    task = request.form['todo']
    tdo.tasks[task] = "done"
    return redirect(url_for('index'))

@app.route('/delete', methods=['POST'])
def removeTask():
    task = request.form['todo']
    del tdo.tasks[task]
    tdo.pasteOut("todoList.json")
    return redirect(url_for('index'))

if __name__ == '__main__':
    app.run(debug=True)
