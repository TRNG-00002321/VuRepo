# To-Do List Manager: Create a program to add, view, mark as complete, and delete tasks from a list/dictionary,
# potentially saving the list/dictionary to a file.
# Please use the following as well while writing code: Functions, Modules (Optional), Imports (Optional)
import json

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


tdo = TodoList()
tdo.readFromFile("listManager.json")
tdo.printTasks()
