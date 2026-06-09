import sys

def main():
    n = int(sys.stdin.readline())
    
    pre = [0] * (n + 1)
    for i in range(1, n):
        pre[i+1] = pre[i] + int(sys.stdin.readline())

    min_val = float('inf')
    
    for i in range(1, n-1):
        val1 = pre[i]
        val2 = pre[n] - pre[i]
        
        if abs(val1 - val2) < 0:
            continue
        else:
            min_val = min(min_val, abs(val1 - val2))
    
    print(min_val)

if __name__ == "__main__":
    main()