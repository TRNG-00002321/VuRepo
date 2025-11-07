from abc import ABC, abstractmethod
import math
from random import triangular


class Shape(ABC):

    @abstractmethod
    def Shape(self):
        pass

    @abstractmethod
    def Area(self):
        pass

class Circle(Shape):
    def __init__(self, radius):
        self.radius = radius
    def Area(self):
        return math.pi*self.radius**2
    def Shape(self):
        return "Circle"

class Rectangle(Shape):
    def __init__(self, width, height):
        self.width = width
        self.height = height
    def Shape(self):
        return "Rectangle"
    def Area(self):
        return self.width*self.height
class Triangle(Shape):
    def __init__(self, side1, side2, side3):
        self.side1 = side1
        self.side2 = side2
        self.side3 = side3
    def Shape(self):
        return "Triangle"
    def Area(self):
        return self.side1*self.side2*self.side3




circle=Circle(5)
print(circle.Shape())
print(f"Circle is {circle.Area()}")

rectangle=Rectangle(10,20)
print(rectangle.Shape())
print(f"Rectangle is {rectangle.Area()}")

triangular=Triangle(10,20,30)
print(triangular.Shape())
print(f"Triangle is {triangular.Area()}")
