import sys
from collections import defaultdict

def main():
    input_data = sys.stdin.read().split()
    if not input_data:
        return
    
    iterator = iter(input_data)
    n = int(next(iterator))
    k = int(next(iterator))
    
    map = defaultdict(list)
    
    for _ in range(k):
        d = int(next(iterator))
        for _ in range(d):
            person = int(next(iterator))
            map[person].append(d)
    
    count = 0
    for i in range(1, n + 1):
        if i not in map:
            count += 1
    
    print(count)

if __name__ == "__main__":
    main()
