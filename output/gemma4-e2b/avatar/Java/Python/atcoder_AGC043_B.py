import sys

def cal(s: str, c: str) -> int:
    n = len(s)
    m = n - 1
    ans = 0
    for i in range(n):
        # Check if s[i] == c AND the i-th bit of m is set
        if s[i] == c and (m & i) == i:
            ans ^= 1
    return ans

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    try:
        n = int(data[0])
        s = data[1]
    except IndexError:
        # Handle case where input might be incomplete
        return
    except ValueError:
        # Handle case where input is not convertible to int/string
        return

    if n == 0:
        return

    # Calculate differences and store them as strings
    sb = []
    for i in range(1, n):
        diff = abs(int(s[i]) - int(