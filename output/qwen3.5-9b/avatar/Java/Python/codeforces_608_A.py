import sys

def main():
    input = sys.stdin.read
    data = input().split()
    iterator = iter(data)
    
    n = int(next(iterator))
    s = int(next(iterator))
    
    max_val = 0
    for _ in range(n):
        f = int(next(iterator))
        t = int(next(iterator))
        max_val = max(max_val, f + t)
    
    print(max(s, max_val))

if __name__ == "__main__":
    main()