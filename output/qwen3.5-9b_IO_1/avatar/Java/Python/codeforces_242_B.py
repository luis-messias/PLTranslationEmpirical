import sys

def main():
    n = int(input())
    a = []
    b = []
    left = float('inf')
    right = 0
    
    for i in range(n):
        a_val, b_val = map(int, input().split())
        a.append(a_val)
        b.append(b_val)
        left = min(left, a_val)
        right = max(right, b_val)
    
    for i in range(n):
        if left == a[i] and right == b[i]:
            print(i + 1)
            return
    
    print(-1)

if __name__ == "__main__":
    main()
