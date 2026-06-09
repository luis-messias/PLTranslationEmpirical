from decimal import Decimal, getcontext

def main():
    line = input().split()
    N = float(line[0])
    d = float(line[1])
    x = float(line[2])
    
    getcontext().prec = 50
    
    ans = Decimal('0.0')
    
    while N > 0.5:
        adnum = Decimal(str(d + x * (N - 0.5)))
        ans += adnum
        d = (N + 1.0) * d / N + (5.0 * x) / (2.0 * N)
        x = (1.0 + (2.0 / N)) * x
        N -= 1
    
    print(f"{ans:.20f}")

if __name__ == "__main__":
    main()
