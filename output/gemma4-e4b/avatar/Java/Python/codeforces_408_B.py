import sys
from collections import Counter

def is_valid(s1: str, s2: str) -> bool:
    """Checks if all characters in s2 are present in s1."""
    s1_chars = set(s1)
    for char in s2:
        if char not in s1_chars:
            return False
    return True

def solve():
    # Read all input tokens (assuming s1 and s2 are the first two tokens)
    try:
        data = sys.stdin.read().split()
        if len(data) < 2:
            # Handle case where input is insufficient
            return
        s1 = data[0]
        s2 = data[1]
    except Exception:
        return

    if not is_valid(s1, s2):
        print(-1)
        return

    # Calculate character frequencies
    m1 = Counter(s1)
    m2 = Counter(s2)

    ans = 0
    # Get unique characters from s2
    unique_chars_s2 = set(s2)

    for char in unique_chars_s2:
        # Get counts, defaulting to 0 if the character is not present
        count1 = m1.get(char, 0)
        count2 = m2.get(char, 0)
        
        # Calculate min frequency and add to answer
        min_freq = min(count1, count2)
        ans += min_freq

    print(ans)

if __name__ == "__main__":
    solve()