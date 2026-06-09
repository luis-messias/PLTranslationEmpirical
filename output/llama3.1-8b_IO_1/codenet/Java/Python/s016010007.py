import math
from typing import List

class Point2D:
    def __init__(self, x: float = 0.0, y: float = 0.0):
        self.x = x
        self.y = y

    def equals(self, a: float, b: float) -> bool:
        return abs(a - b) < 1e-10

    def sum(self, b: 'Point2D') -> 'Point2D':
        return Point2D(self.x + b.x, self.y + b.y)

    def diff(self, b: 'Point2D') -> 'Point2D':
        return Point2D(self.x - b.x, self.y - b.y)

    def multiple(self, k: float) -> 'Point2D':
        return Point2D(self.x * k, self.y * k)

    def norm(self) -> float:
        return self.x ** 2 + self.y ** 2

    def __str__(self):
        return f"{self.x:.10f} {self.y:.10f}"

class Vector(Point2D):
    def dot(self, a: 'Point2D', b: 'Point2D') -> float:
        return a.x * b.x + a.y * b.y

    def cross(self, a: 'Point2D', b: 'Point2D') -> float:
        return a.x * b.y - a.y * b.x

def jadge_clockwise(p0: Point2D, p1: Point2D, p2: Point2D) -> str:
    v = Vector()
    a = p1.diff(p0)
    b = p2.diff(p0)

    if abs(v.cross(a, b)) > 1e-10: 
        return "COUNTER_CLOCKWISE"
    elif abs(v.cross(a, b)) < -1e-10: 
        return "CLOCKWISE"
    elif v.dot(a, b) < -1e-10: 
        return "ONLINE_BACK"
    elif a.norm() < b.norm(): 
        return "ONLINE_FRONT"

    return "ON_SEGMENT"

def main():
    lines = [line.strip().split(' ') for line in open(0, 'r').readlines()][2:]
    q = int(lines[1][0])
    buf = ''
    p0 = Point2D(float(lines[0][0]), float(lines[0][1]))
    p1 = Point2D(float(lines[0][2]), float(lines[0][3]))
    for i in range(q):
        p2 = Point2D(float(lines[i+2][0]), float(lines[i+2][1]))
        buf += jadge_clockwise(p0, p1, p2) + '\n'

    print(buf)

if __name__ == "__main__":
    main()
