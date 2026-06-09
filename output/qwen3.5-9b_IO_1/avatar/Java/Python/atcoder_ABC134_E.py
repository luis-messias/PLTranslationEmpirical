import sys
from collections import defaultdict

def main():
    data = sys.stdin.read().split()
    n = int(data[0])
    map = defaultdict(int)
    
    for i in range(1, n + 1):
        num = int(data[i])
        if map[num - 1] == 0:
            val = map[num]
            map[num] = val + 1
        else:
            key = num - 1
            val = map[key]
            if val == 1:
                del map[key]
            else:
                map[key] = val - 1
            val = map[num]
            map[num] = val + 1
    
    ans = sum(map.values())
    print(ans)

if __name__ == "__main__":
    main()
