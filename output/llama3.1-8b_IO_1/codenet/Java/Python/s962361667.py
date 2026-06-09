import sys

def main():
    w, n = map(int, input().split())
    values = list(range(1, w + 1))
    
    for _ in range(n):
        str = input()
        ab = str.split(",")
        a = int(ab[0]) - 1
        b = int(ab[1]) - 1
        values[a], values[b] = values[b], values[a]
        
    print(*values)

if __name__ == "__main__":
    main()
