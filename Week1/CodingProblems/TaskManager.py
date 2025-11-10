import json

class TaskManager:
    def __init__(self):
        self.tasks = {}

    def addTask(self, task):
        if task not in self.tasks:
            self.tasks[task] = 'not done'
        else :
            print("Task already added!")

    def removeTask(self, task):
        if task in self.tasks:
            del self.tasks[task]
            print(f"Task {task} was removed")
        else:
            print("Task not exist")

    def markDone(self, task):
        if task in self.tasks:
            self.tasks[task] = 'done'
        else:
            print("Task not found")

    def printTasks(self):
        for i, task in enumerate(self.tasks):
            print(f"Task {i}: {task} is {self.tasks[task]}")

    def takeIn(self,filename):
        try:
            with open(filename) as f:
                self.tasks = json.load(f)
                print(f"Tasks loaded from {filename} successfully")
        except FileNotFoundError:
            print("File not found")

    def pasteOut(self, filename):
        with open(filename, "w") as f:
            json.dump(self.tasks, f)
            print(f"Tasks saved to {filename} successfully")

tdo = TaskManager()
tdo.takeIn("listManager.json")
tdo.printTasks()
tdo.pasteOut("todoList.json")