import sys
from collections import defaultdict

def main():
    input = sys.stdin.read().strip()
    test_cases, K, S = map(int, input.split())
    
    ans = 0
    for x in range(K + 1):
        for y in range(K + 1):
            wk = S - x - y
            if 0 <= wk <= K:
                ans += 1
    
    print(ans)

if __name__ == "__main__":
    main()