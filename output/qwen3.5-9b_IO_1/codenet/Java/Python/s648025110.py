import sys

def main():
    input_data = sys.stdin.read().split()
    n = int(input_data[0])
    h = [int(input_data[i + 1]) for i in range(n)]
    
    ans = 0
    out = 0
    
    for i in range(n):
        if out < h[i]:
            ans += h[i] - out
            out = h[i]
        else:
            out = h[i]
    
    print(ans)

if __name__ == "__main__":
    main()
