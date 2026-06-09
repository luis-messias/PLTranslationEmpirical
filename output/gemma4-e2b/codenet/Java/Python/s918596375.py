import sys

def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

def lcm(a, b):
    if a == 0 or b == 0:
        return 0
    return abs(a * b) // gcd(a, b)

def solve():
    # Read the single string input
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
    else:
        print("consonant")

if __name__ == "__main__":
    solve()