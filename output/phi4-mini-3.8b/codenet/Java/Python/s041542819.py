import sys
from bisect import bisect_left

class DLazyFaith:
    def solve(self, a, b, q, s_values, t_values):
        s = [-10_000_000_000] + sorted(s_values) + [20_000_000_000]
        t = [-10_000_000_000] + sorted(t_values) + [20_000_000_000]

        results = []
        for x in q:
            sl = max(0, bisect_left(s, x+1)) - 1
            tl = max(0, bisect_left(t, x+1)) - 1

            sr = s[bisect_left(s, x)] - x if bisect_left(s, x) < len(s) else float('inf')
            tr = t[bisect_left(t, x)] - x if bisect_left(t, x) < len(t) else float('inf')

            results.append(min(
                max(sl, tl),
                max(sr, tr),
                2 * sl + tr,
                2 * tl + sr,
                sl + 2 * tr,
                tl + 2 * sr
            ))

        return results

def main():
    input = sys.stdin.read
    data = list(map(int, input().split()))
    
    a, b, q = data[0], data[1], data[2]
    s_values = data[3:a+4]
    t_values = data[a+4:b+5]

    solver = DLazyFaith()
    results = solver.solve(a, b, q, s_values, t_values)

    for result in results:
        print(result)

if __name__ == "__main__":
    main()