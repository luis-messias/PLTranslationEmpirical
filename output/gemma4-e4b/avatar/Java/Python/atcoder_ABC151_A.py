class RemRing:
    def __init__(self, module):
        self.module = module

    def sum(self, a, b):
        return (a + b) % self.module

    def sub(self, a, b):
        # Equivalent to (a - b) % module, ensuring positive result
        return (a - b) % self.module

    def prod(self, a, b):
        return (a * b) % self.module

    def div(self, a, b):
        return (a * self.inv(b)) % self.module

    def inv(self, a):
        # Extended Euclidean Algorithm
        b_mod = self.module
        u = 1
        v = 0
        
        # We use copies of a and b_mod for the algorithm variables
        a_curr = a
        b_curr = b_mod

        while b_curr > 0:
            # t = a / b (integer division)
            t = a_curr // b_curr
            
            # Update a_curr: a_new = a_old - t * b_old
            a_curr = a_curr - t * b_curr
            
            # Update u: u_new = u_old - t * v_old
            u = u - t * v
            
            # Store current a_curr (z)
            z = a_curr
            
            # Shift: a_curr = b_curr, b_curr = z
            a_curr = b_curr
            b_curr = z
            
            # Shift: u = v, v = z
            z = u
            u = v
            v = z
        
        # The result is in u
        result = u % self.module
        if result < 0:
            result += self.module
        return result

class atcoder_ABC151_A:
    @staticmethod
    def main():
        import sys
        # Read the entire line from standard input
        try:
            s = sys.stdin.readline().strip()
        except EOFError:
            return

        if not s:
            return

        # Get the first character, increment its ASCII value, and print the character.
        # ord(s[0]) gets the integer value (ASCII/Unicode).
        # chr(...) converts the integer value back to a character.
        result_char = chr(ord(s[0