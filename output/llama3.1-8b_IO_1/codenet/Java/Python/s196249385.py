import sys
from typing import List

class Scanner:
    def __init__(self, files):
        self.files = files

    def next(self):
        return next(self.files).strip()

    def next_ints(self):
        return [int(x) for x in self.next().split()]

def solve():
    sc = Scanner(sys.stdin)
    pr = Printer(sys.stdout)

    n, k = sc.next_ints()
    a = sc.next_ints()
    
    cumsum = [0] * (n + 1)
    for i in range(n):
        cumsum[i + 1] = cumsum[i] + a[i]

    b = []
    max_val = 0
    for i in range(n):
        for j in range(i, n):
            b.append(cumsum[j + 1] - cumsum[i])
            max_val = max(max_val, cumsum[j + 1] - cumsum[i])

    mask = 1 << (max_val.bit_length())
    while mask > 0:
        tmp = [e for e in b if (e & mask) != 0]
        
        if len(tmp) >= k:
            b = tmp
        
        mask >>= 1

    if len(b) < k:
        pr.println(0)
    else:
        ans = -1
        for e in b:
            ans &= e
            
        pr.println(ans)

class Printer:
    def __init__(self, stream):
        self.stream = stream

    def println(self, obj):
        print(obj, file=self.stream)

def main():
    solve()
    pr.close()

if __name__ == "__main__":
    main()
