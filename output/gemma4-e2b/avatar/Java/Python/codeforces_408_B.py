import sys
from collections import Counter

def isValid(s1: str, s2: str) -> bool:
    """Checks if all characters in s2 are present in s1."""
    set_s1 = set(s1)
    for char in s2:
        if char not in set_s1:
            return False
    return True

def solve():
    # Read input from standard input
    try:
        # Read s1 and s2, assuming they are provided on separate lines or space-separated if reading line by line
        # Based on s.next() in Java, we read two tokens.
        data = sys.stdin.read().split()
        if len(data) < 2:
            return
        s1 = data[0]
        s2 = data[1]
    except Exception:
        return

    if not isValid(s1, s2):
        print(-1)
        return

    # Calculate frequencies
    m1 = Counter(s1)
    m2 = Counter(s2)

    ans = 0
    
    # Iterate over unique characters in s2 to calculate the sum
    for char in set(s2):
        # Since isValid passed, we know the character exists in both strings
        x1 = m