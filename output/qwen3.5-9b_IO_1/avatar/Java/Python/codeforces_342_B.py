import sys
from collections import defaultdict

def main():
    input_data = sys.stdin.read().split()
    iterator = iter(input_data)
    
    m = int(next(iterator))
    s = int(next(iterator))
    f = int(next(iterator))
    
    map = defaultdict(list)
    maxT = -1
    
    for _ in range(m):
        k = int(next(iterator))
        a = int(next(iterator))
        b = int(next(iterator))
        map[k] = [a, b]
        maxT = max(maxT, k)
    
    actions = []
    d = 1 if s < f else -1
    M = 'R' if s < f else 'L'
    cur = s
    
    for t in range(1, maxT + 1):
        if t in map:
            a = map[t][0]
            b = map[t][1]
        
        if t in map and ((cur >= a and cur <= b) or (cur + d >= a and cur + d <= b)):
            actions.append('X')
        else:
            actions.append(M)
            cur += d
        
        if cur == f:
            break
    
    while cur != f:
        actions.append(M)
        cur += d
    
    print(''.join(actions))

if __name__ == "__main__":
    main()
