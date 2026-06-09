import sys
import math

# The Pair class is not strictly necessary for the main logic (solve) 
# but is included for structural completeness if it were used elsewhere.
# Since it's an internal utility class in the Java code, we can omit a direct translation 
# if it's unused, but if we must translate it:
class Pair:
    def __init__(self, key, value):
        self.key = key
        self.value = value

    def swap(self):
        return Pair(self.value, self.key)

# FastScanner replacement: Using standard input reading
# Since the Java code only uses sc.next() to read one token, 
# we can simplify input handling significantly.

def solve():
    # Read the single string input 's'
    try:
        s = sys.stdin.readline().strip()
    except EOFError:
        return

    if not s:
        return

    vowels = {"a", "e", "i", "o", "u"}
    
    # Check if the string is a vowel (case-insensitive)
    s_lower = s.lower()
    if s_lower in vowels:
        print("vowel")
        return
    
    print("consonant")

def gcd(a, b):
    # Python's math.gcd handles this efficiently
    return math.gcd(a, b)

def lcm(a, b):
    if a == 0 or b == 0:
        return 0
    # Use math.gcd for robustness
    return abs(a * b) // gcd(a, b)

def main():
    # The Java structure calls solve(sc, out)
    solve()

if __name__ == "__main__":
    main()