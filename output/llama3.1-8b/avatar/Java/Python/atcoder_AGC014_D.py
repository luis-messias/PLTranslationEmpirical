from collections import defaultdict
import sys

g = defaultdict(list)
def max_matching(v, p):
    a = 0
    o = 0
    for w in g[v]:
        if w == p:
            continue
        r = max_matching(w, v)
        a += r // 2
        o += r % 2
    return 2 * a + min(1, o) + 1

def main():
    n = int(input())
    for i in range(n - 1):
        a, b = map(int, input().split()) - 1
        g[a].append(b)
        g[b].append(a)

    m = max_matching(0, -1) // 2
    print("Second" if 2 * m == n else "First")

if __name__ == "__main__":
    main()