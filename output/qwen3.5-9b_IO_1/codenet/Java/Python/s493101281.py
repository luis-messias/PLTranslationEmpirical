import sys

def main():
    data = sys.stdin.read().split()
    if not data:
        return
    
    n = int(data[0])
    l = [int(x) for x in data[1:n+1]]
    
    l.sort()
    
    print(l[n//2] - l[n//2-1])

if __name__ == "__main__":
    main()
