import sys

def main():
    input_data = sys.stdin.read().split()
    iterator = iter(input_data)
    
    n = int(next(iterator))
    k = int(next(iterator))
    
    a = [int(next(iterator)) for _ in range(n)]
    
    a.sort()
    
    print(sum(a[:k]))

if __name__ == "__main__":
    main()