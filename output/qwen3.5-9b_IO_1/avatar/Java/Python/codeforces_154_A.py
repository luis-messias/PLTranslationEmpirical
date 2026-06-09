import sys

def main():
    infile = sys.stdin
    arr = infile.readline().strip()
    N = len(arr)
    K = int(infile.readline().strip())
    res = 0
    
    for _ in range(K):
        input_str = infile.readline().strip()
        a = 0
        b = 0
        for i in range(N):
            if arr[i] == input_str[0]:
                a += 1
            elif arr[i] == input_str[1]:
                b += 1
            else:
                res += min(a, b)
                a = 0
                b = 0
        res += min(a, b)
    
    print(res)

if __name__ == "__main__":
    main()
