import sys

def main():
    w, n = map(int, input().split())
    values = list(range(1, w + 1))
    
    for _ in range(n):
        str = input()
        a, b = map(int, str.split(','))
        a -= 1
        b -= 1
        values[a], values[b] = values[b], values[a]
        
    print(*values)

if __name__ == "__main__":
    main()