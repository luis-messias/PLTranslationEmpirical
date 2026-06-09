import sys
from bisect import bisect_left, insort

def solve():
    input_data = sys.stdin.read().split()
    iterator = iter(input_data)
    
    n = int(next(iterator))
    left = set(range(n))
    answer = [0] * n
    
    q = int(next(iterator))
    
    for _ in range(q):
        l = int(next(iterator)) - 1
        r = int(next(iterator)) - 1
        win = int(next(iterator))
        
        # Find ceiling of l
        while True:
            # Find smallest element >= l
            candidates = [x for x in left if x >= l]
            if not candidates:
                break
            curr = min(candidates)
            
            if curr > r:
                break
            
            answer[curr] = win
            left.remove(curr)
        
        answer[win - 1] = 0
        left.add(win - 1)
    
    print(*(answer))

if __name__ == "__main__":
    solve()