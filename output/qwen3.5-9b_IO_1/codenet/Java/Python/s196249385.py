import sys
from io import StringIO

class Printer:
    def __init__(self, out):
        self.out = out
    
    def println(self, x):
        self.out.write(str(x) + '\n')
    
    def close(self):
        pass

def solve():
    input_data = sys.stdin.read().split()
    if not input_data:
        return
    
    n = int(input_data[0])
    k = int(input_data[1])
    
    a = [int(input_data[i+2]) for i in range(n)]
    
    cumsum = [0] * (n + 1)
    for i in range(n):
        cumsum[i + 1] = cumsum[i] + a[i]
    
    b = []
    max_val = 0
    for i in range(n):
        for j in range(i, n):
            subarray_sum = cumsum[j + 1] - cumsum[i]
            b.append(subarray_sum)
            max_val = max(max_val, subarray_sum)
    
    mask = 1 << (max_val.bit_length() - 1) if max_val > 0 else 0
    
    while mask > 0:
        tmp = []
        for e in b:
            if (e & mask) != 0:
                tmp.append(e)
        
        if len(tmp) >= k:
            b = tmp
        
        mask >>= 1
    
    if len(b) < k:
        print(0)
    else:
        ans = -1
        for e in b:
            ans &= e
        print(ans)

if __name__ == "__main__":
    solve()
