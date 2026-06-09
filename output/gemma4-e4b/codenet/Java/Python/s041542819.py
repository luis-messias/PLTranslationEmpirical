import sys
import math

# Set recursion limit higher for safety, although not strictly necessary here
# sys.setrecursionlimit(2000)

class ArrayUtil:
    @staticmethod
    def lower_bound(a, t):
        """
        Finds the index of the first element in sorted array a that is >= t.
        Returns len(a) if all elements are < t.
        """
        low = 0
        high = len(a)
        while low < high:
            mid = (low + high) // 2
            if t <= a[mid]:
                high = mid
            else:
                low = mid + 1
        return low

class IntMath:
    @staticmethod
    def min_val(*args):
        if not args:
            raise ValueError("min() requires at least one argument")
        return min(args)

class LightWriter:
    def __init__(self):
        # Using sys.stdout.write for efficient output handling
        self.output = sys.stdout
        self.breaked = True

    def print_char(self, c):
        try:
            self.output.write(c)
            self.breaked = False
        except Exception:
            pass
        return self

    def print_string(self, s):
        try:
            self.output.write(s)
            self.breaked = False
        except Exception:
            pass
        return self

    def ans(self, s):
        if not self.breaked:
            self.print_char(' ')
        return self.print_string(str(s))

    def ans_long(self, l):
        return self.ans(l)

    def ansln(self, *n_list):
        for n1 in n_list:
            self.ans(n1).ln()
        return self

    def ln(self):
        self.print_char('\n')
        self.breaked = True
        # Flushing is usually handled by the runtime environment in Python,
        # but we keep the structure for conceptual fidelity.
        return self

    def close(self):
        # In Python, explicit closing of stdout is usually not required
        pass

class LightScanner:
    def __init__(self, input_stream):
        # Read all input tokens into a list
        self.tokens = []
        self.token_index = 0
        
        # Read all lines and split them into tokens
        input_data = sys.stdin.read().split()
        self.tokens = input_data
        self.token_index = 0

    def string(self):
        if self.token_index >= len(self.tokens):
            raise