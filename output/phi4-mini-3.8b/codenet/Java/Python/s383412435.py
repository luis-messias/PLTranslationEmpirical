import sys

def main():
    input = sys.stdin.read
    data = input().split()
    
    N = int(data[0])
    a = list(map(int, data[1:N+1]))
    ans = 0
    
    if len(a) == 1 and a[0] > 1:
        ans = 1
    else:
        for j in range(N):
            tmp = 1
            
            while (j + 1 < N and a[j] == a[j + 1]):
                tmp += 1
                j += 1
                
            if tmp > a[j]:
                ans += tmp - a[j]
            elif tmp < a[j]:
                ans += tmp
    
    print(ans)

if __name__ == "__main__":
    main()