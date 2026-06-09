import sys

def main():
    input_data = sys.stdin.read().split()
    iterator = iter(input_data)
    
    m = int(next(iterator))
    n = int(next(iterator))
    x = int(next(iterator))
    y = int(next(iterator))
    
    a = []
    for _ in range(m):
        a.append(int(next(iterator)))
    
    b = []
    for _ in range(n):
        b.append(int(next(iterator)))
    
    x_max = max(x, *a)
    y_min = min(y, *b)
    
    if x_max >= y_min:
        print("War")
    else:
        print("No War")

if __name__ == "__main__":
    main()
