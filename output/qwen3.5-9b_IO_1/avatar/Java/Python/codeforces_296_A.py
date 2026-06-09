import sys

def solve():
    n = int(input())
    counts = {}
    
    numbers = list(map(int, input().split()))
    
    for num in numbers:
        counts[num] = counts.get(num, 0) + 1
    
    countMax = max(counts.values())
    
    if n % 2 == 0:
        if countMax <= n // 2:
            print("YES")
        else:
            print("NO")
    else:
        if countMax <= n // 2 + 1:
            print("YES")
        else:
            print("NO")

if __name__ == "__main__":
    solve()
