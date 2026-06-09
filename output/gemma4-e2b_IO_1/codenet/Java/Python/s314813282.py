import sys

def max_int(x, a):
    bignum = x
    for val in a:
        if val > bignum:
            bignum = val
    return bignum

def min_int(y, b):
    smallnum = y
    for val in b:
        if val < smallnum:
            smallnum = val
    return smallnum

def check_war(a, b):
    if a >= b:
        print("War")
    else:
        print("No War")

def main():
    # Read all input from stdin
    data = sys.stdin.read().split()
    
    if len(data) < 4:
        return

    # Parse m, n, x, y
    m = int(data[0])
    n = int(data[1])
    x = int(data[2])
    y = int(data[3])
    
    # Parse array a
    a = [int(d) for d in data[4 : 4 + m]]
    
    # Parse array b
    b = [int(d) for d in data[4 + m : 4 + m + n]]

    # Calculate x_max = max(x, a[i])
    x_max = max_int(x, a)
    
    # Calculate y_min = min(y, b[i])
    y_min = min_int(y, b)
    
    # CheckWar(x_max, y_min)
    check_war(x_max, y_min)

if __name__ == "__main__":
    main()
