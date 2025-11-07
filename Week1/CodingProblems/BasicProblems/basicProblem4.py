# You are given two integer variables x and y. You need to perform the following operations:

class Operation:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def addition(self):
        return self.x + self.y
    def subtraction(self):
        return self.x - self.y
    def multiplication(self):
        return self.x * self.y
    def division(self):
        return self.x / self.y
    def modulus(self):
        return self.x % self.y

p = Operation(1, 2)
print(p.addition())
q = Operation(3, 4)
print(q.subtraction())
r = Operation(5, 6)
print(r.multiplication())
s = Operation(6, 2)
print(s.division())
t = Operation(7, 3)
print(t.modulus())