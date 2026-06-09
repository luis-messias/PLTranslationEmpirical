import sys

def solve():
    # Read the single token input, mimicking Java's sc.next()
    try:
        s = sys.stdin.read().strip()
    except:
        # Fallback for environments where sys.stdin.read() might fail or read too much
        s = input().strip()

    total = 0
    n = len(s)

    for i in range(n):
        for j in range(i + 1, n):
            if s[i] == s[j]:
                total += 1

    print("Yes" if total == 2 else "No")

solve()