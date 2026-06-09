import sys
import math

# Define a small epsilon for floating point comparisons
EPS = 1e-10

class Point2D:
    def __init__(self, x, y):
        self.x = float(x)
        self.y = float(y)

    def sum(self, other):
        return Point2D(self.x + other.x, self.y + other.y)

    def diff(self, other):
        return Point2D(self.x - other.x, self.y - other.y)

    def multiple(self, k):
        return Point2D(self.x * k, self.y * k)

    def norm(self):
        # Returns squared magnitude (x^2 + y^2) as per Java implementation
        return self.x * self.x + self.y * self.y

    def abs(self, other):
        # Calculates the magnitude (distance) to another point
        return math.sqrt(self.norm() - other.norm() + 2 * self.x * other.x + 2 * self.y * other.y) # Simplified norm calculation based on context, but Java used norm() for squared magnitude. Let's stick to the Java implementation's intent for norm() being squared magnitude.
        # Re-evaluating Java: Java's norm() returns x*x + y*y. abs(Point2D a) returns sqrt(a.norm()).
        return math.sqrt(self.norm())

    def __str__(self):
        return f"{self.x:.10f} {self.y:.10f}"

class Vector(Point2D):
    def dot(self, a: Point2D, b: Point2D) -> float:
        return self.x * a.x + self.y * a.y

    def cross(self, a: Point2D, b: Point2D) -> float:
        # 2D cross product (magnitude of the resulting 3D vector)
        return self.x * b.y - self.y * b.x

    def is_parallel(self, a: Point2D, b: Point2D) -> bool:
        # Checks if the cross product is zero
        return abs(self.cross(a, b)) < EPS

    def is_orthogonal(self, a: Point2D, b: Point2D) -> bool:
        # Checks if the dot product is zero
        return abs(self.dot(a, b)) < EPS

    def project(self, sp1: Point2D, sp2: Point2D, p: Point2D) -> Point2D:
        # Projection of vector (p - sp1) onto vector (sp2 - sp1)
        base = sp2.diff(sp1)
        
        # Handle zero length base case (though context implies non-zero)
        base_norm_sq = base.norm()
        if base_norm_sq < EPS:
            return sp1 # Cannot project onto a zero vector

        # r = (p - sp1) . base / |base|^2
        # The Java implementation seems to calculate r = (p - sp1) . base / |base|^2, but then uses it differently.
        # Java: double r = dot(p.diff(sp1), base) / base.norm();
        
        v_p_sp1 = p.diff(sp1)
        r = self.dot(v_p_sp1, base) / base_norm_sq

        # Result = sp1 + base * r
        return sp1.sum(base.multiple(r))

    def reflect(self, sp1: Point2D, sp2: Point2D, p: Point2D) -> Point2D:
        # Reflection formula: p + 2 * proj_vector - p
        # Java: return p.sum(project(sp1,sp2,p).diff(p).multiple(2.0));
        
        # Calculate projection of (p - sp1) onto (sp2 - sp1)
        proj_vec = self.project(sp1, sp2, p)
        
        # The reflection calculation seems to be: p + 2 * (proj_vec - p)
        # Let's follow the Java structure strictly:
        # proj_vec_diff = proj_vec.diff(p)
        # reflection = p.sum(proj_vec_diff.multiple(2.0))
        
        return p.sum(proj_vec.diff(p).multiple(2.0))


def jadgeClockwise(p0: Point2D, p1: Point2D, p2: Point2D) -> str:
    """
    Determines the orientation of the ordered triplet (p0, p1, p2).
    Based on the cross product and dot product checks.
    """
    # Vector v = p1 - p0
    v = p1.diff(p0)
    # Vector a = p2 - p0
    a = p2.diff(p0)

    # Cross product check: v x a
    cross_prod = v.cross(a)