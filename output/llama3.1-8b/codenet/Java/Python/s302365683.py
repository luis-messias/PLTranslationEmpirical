import sys
from collections import defaultdict

def main():
    n = int(input())
    hm = defaultdict(int)

    for _ in range(n):
        val = int(input())
        hm[val] += 1

    ans = 0
    for val, num in hm.items():
        if num > val:
            ans += num - val
        else:
            ans += num

    print(ans)

if __name__ == "__main__":
    main()