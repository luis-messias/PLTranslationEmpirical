import math
import sys

# Helper class for 2D points/vectors
class Point2D:
    """Represents a point or a vector in 2D space."""
    EPS = 1e-10

    def __init__(self, x, y):
        self.x = float(x)
        self.y = float(y)

    def __repr__(self):
        return f"({self.x:.10f}, {self.y:.10f})"

    def equals(self, other_point, tolerance=None):
        """Checks if coordinates are approximately equal."""
        if tolerance is None:
            tolerance = self.EPS
        return abs(self.x - other_point.x) < tolerance and abs(self.y - other_point.y) < tolerance

    def sum(self, other):
        """Returns the sum of two points/vectors."""
        return Point2D(self.x + other.x, self.y + other.y)

    def diff(self, other):
        """Returns the difference (self - other)."""
        return Point2D(self.x - other.x, self.y - other.y)

    def multiple(self, k):
        """Returns the vector scaled by k."""
        return Point2D(self.x * k, self.y * k)

    def norm_sq(self):
        """Returns the squared magnitude (norm^2)."""
        return self.x * self.x + self.y * self.y

    def norm(self):
        """Returns the magnitude (norm)."""
        return math.sqrt(self.norm_sq())

    def abs(self, other):
        """Returns the distance between self and other."""
        return math.sqrt((self.x - other.x)**2 + (self.y - other.y)**2)

    def __str__(self):
        return f"{self.x:.10f} {self.y:.10f}"

# Helper class for vector operations
class Vector(Point2D):
    """Extends Point2D with vector operations like dot and cross product."""

    def dot(self, a, b):
        """Calculates the dot product of two