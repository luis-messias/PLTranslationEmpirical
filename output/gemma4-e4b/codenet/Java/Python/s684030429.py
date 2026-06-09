import math
import sys

class Main:
    def __init__(self):
        # In Python, we typically handle input directly or pass a stream.
        # Since the Java code uses a Scanner initialized on System.in, 
        # we will rely on standard input reading functions.
        pass

    def solve(self):
        # ni() reads an integer from scanner
        try:
            # Reading two integers from standard input, assuming they are provided sequentially
            a = int(sys.stdin.readline().strip())
            b = int(sys.stdin.readline().strip())
        except:
            # Handle case where input might be missing
            return

        # System.out.println(Math.max(0, a-2*b));
        print(max(0, a - 2 * b))

# Utility methods translation (kept for structural completeness)

    # input an integer from scanner
    def ni(self):
        try:
            return int(sys.stdin.readline().strip())
        except:
            return 0

    # input a long from scanner
    def nl(self):
        try:
            return int(sys.stdin.readline().strip())
        except:
            return 0

    # input a float from scanner
    def nf(self):
        try:
            return float(sys.stdin.readline().strip())
        except:
            return 0.0

    # input a double from scanner
    def nd(self):
        try:
            return float(sys.stdin.readline().strip())
        except:
            return 0.0

    # input a sentence from scanner
    def ns(self):
        return sys.stdin.readline().strip()

    # converts a string to stringtokenizer (Python equivalent is splitting)
    def nst(self, s):
        return s.split()

    # input an intger array
    def ia(self, a):
        # Assuming 'a' is a list passed by reference
        for i in range(len(a)):
            try:
                a[i] = int(sys.stdin.readline().strip())
            except:
                a[i] = 0

    # input a long array
    def la(self, a):
        for i in range(len(a)):
            try:
                a[i] = int(sys.stdin.readline().strip())
            except:
                a[i] = 0

    # input a float array
    def fa(self, a):
        for i in range(len(a)):
            try:
                a[i] = float(sys.stdin.readline().strip())
            except:
                a[i] = 0.0

    # input a double array
    def da(self, a):
        for i in range(len(a)):
            try:
                a[i] = float(sys.stdin.readline().strip())
            except:
                a[i] = 0.0

    # input a string array
    def sa(self, a, empty):
        if empty:
            for i in range(len(a)):
                a[i] = ""
        else:
            for i in range(len(a)):
                a[i] = sys.stdin.readline().strip()

    # input two dimensional integer array
    def ida(self, a, n, m):
        for i in range(n):
            for j in range(m):
                try:
                    a[i][j] = int(sys.stdin.readline().strip())
                except:
                    a[i][j] = 0

    # input two dimentional long array
    def lda(self, a, n, m):
        for i in range(n):
            for j in range(m):
                try:
                    a[i][j] = int(sys.stdin.readline().strip())
                except:
                    a[i][j] = 0

    # input two dimensional double array
    def dda(self, a, n, m):
        for i in range(n):
            for j in range(m):
                try:
                    a[i][j] = float(sys.stdin.readline().strip())
                except:
                    a[i][j] = 0.0

    # convert string to integer
    def stoi(self, s):
        try:
            return int(s)
        except ValueError:
            return 0

    # convert string to double
    def stod(self, s):
        try:
            return float(s)
        except ValueError:
            return 0.0

    # find minimum in a long array
    def lmin(self, a):
        if not a: return 0
        return min(a)

    # find minimum in a integer array
    def imin(self, a):
        if not a: return 0
        return min(a)

    # find maximum in a long array
    def lmax(self, a):
        if not a: return 0
        return max(a)

    # find maximum in an integer array
    def imax(self, a):
        if not a: return 0
        return max(a)

    # check whether an element is present in an integer array by
    def contains(self, arr, target):
        return target in arr

    # Helper function for the original code's structure (not fully implemented logic)
    def solve(self):
        pass

# Main execution block
if __name__ == "__main__":
    solver = MainSolver()
    solver.solve()