import sys

def main():
    input_data = sys.stdin.read().split()
    if not input_data:
        return
    
    N = int(input_data[0])
    a = [int(x) for x in input_data[1:N+1]]
    
    a.sort()
    
    if N == 1 and a[0] > 1:
        ans = 1
    else:
        ans = 0
        for j in range(N):
            if j == 0 or a[j] != a[j - 1]:
                tmp = 1
                for i in range(j + 1, N):
                    if a[j] == a[i]:
                        tmp += 1
                    else:
                        break
                
                if tmp > a[j]:
                    ans += tmp - a[j]
                elif tmp < a[j]:
                    ans += tmp
    
    print(ans)

if __name__ == "__main__":
    main()
