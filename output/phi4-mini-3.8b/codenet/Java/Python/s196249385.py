import sys

def solve():
    n, k = map(int, input().split())
    
    a = list(map(int, input().split()))
    
    cumsum = [0] * (n + 1)
    for i in range(n):
        cumsum[i+1] = cumsum[i] + a[i]
        
    b = []
    max_val = float('-inf')
    for i in range(n):
        for j in range(i, n):
            val = cumsum[j+1] - cumsum[i]
            if val > 0:
                b.append(val)
                max_val = max(max_val, val)

    mask = (max_val ^ ((-1) << len(bin(max_val))[-2:]) + 'b')[:-len('b')]
    
    while bin(mask).count('1') > k and mask != 0:
        tmp = [e for e in b if int(e & mask)]
        
        if len(tmp) >= k:
            b, max_val = sorted(set(b), reverse=True)
            
        else: 
            break
        
        mask >>= 1

    ans = -1
    for val in b[:k]:
        ans &= val
    
    print(ans)

if __name__ == "__main__":
    solve()