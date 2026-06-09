import sys
from math import sqrt

EPS = 1e-10


class Vector:
    def __init__(self):
        pass

    @staticmethod
    def cross(a, b):
        return a.x * b.y - a.y * b.x

    @staticmethod
    def dot(a, b):
        return a.x * b.x + a.y * b.y

    @staticmethod
    def norm(v):
        return sqrt(v.dot(v))

    @staticmethod
    def isOrthogonal(a1, a2, b1, b2):
        return Vector.cross(a1.diff(a2), b1.diff(b2)) == 0.0

    @staticmethod
    def isParallel(a1, a2, b1, b2):
        return Vector.cross(a1.diff(a2), b1.diff(b2)) == 0.0


class Point:
    EPS = 1e-10

    def __init__(self, x=0, y=0):
        self.x = float(x)
        self.y = float(y)

    @staticmethod
    def diff(p1, p2):
        return Vector().multiple(Point(p2).diff(p1))

    @staticmethod
    def multiple(k):
        return Point(k * (p.x), k * (p.y))


def crossClockwise(a, b, c):
    v = a.diff(b)
    w = c.diff(b)

    if abs(Vector.cross(v, w)) > EPS:
        cp = Vector().cross(w, v) / Vector.norm(v)
        return "COUNTER_CLOCKWISE" if cp < 0 else "CLOCKWISE"
    
    abp = b.x - a.x
    acp = c.x - a.x

    apq = abs(a.y * (b.x + c.x)) > EPS and \
          abs(b.y * (a.x + c.x)) > EPS and \
          abs(c.y * (a.x + b.x)) > EPS
    
    if Vector.dot(v, w) < 0 or abp == acp:
        return "ONLINE_BACK" if apq else "ON_SEGMENT"
    
    bp = Point(b.x - a.x)
    cp = c.diff(a)

    bc = abs(bp * (cp.y + v.y)) > EPS and \
         abs(cp * (-bp * b.y) / Vector.norm(v)) < 0
    
    return "ONLINE_FRONT" if apq else ("ON_SEGMENT" if not bc else "LINEAR")


def main():
    input_data = sys.stdin.read().strip().splitlines()
    
    p1, q = map(int, input_data[0].split())
    points = [Point(*map(float, line.split())) for line in input_data[1:p1 + 2]]
    
    results = []
    for i in range(p1):
        point = Point(*map(float, sys.stdin.readline().strip().split()))
        result = crossClockwise(points[i], p1, point)
        results.append(result)

    print("\n".join(results))


if __name__ == "__main__":
    main()