import sys

def main():
    input_data = sys.stdin.read().split()
    iterator = iter(input_data)
    
    N = int(next(iterator))
    M = int(next(iterator))
    
    a = [0] * N
    
    for i in range(M):
        k = int(next(iterator))
        for j in range(k):
            s = int(next(iterator)) - 1
            a[s] |= (1 << i)
    
    p = 0
    for i in range(M):
        x = int(next(iterator))
        p |= (x << i)
    
    ans = 0
    for s in range(1 << N):
        t = 0
        for i in range(N):
            if (s >> i) & 1:
                t ^= a[i]
        if p == t:
            ans += 1
    
    print(ans)

if __name__ == "__main__":
    main()
