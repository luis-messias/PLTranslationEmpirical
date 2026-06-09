import sys

def main():
    w = int(input())
    n = int(input())
    values = list(range(1, w + 1))
    
    for _ in range(n):
        line = input().strip()
        a, b = map(int, line.split(','))
        a -= 1
        b -= 1
        values[a], values[b] = values[b], values[a]
    
    for val in values:
        print(val)

if __name__ == "__main__":
    main()
