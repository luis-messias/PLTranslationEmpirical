import sys

def main():
    input_data = sys.stdin.read().split()
    if not input_data:
        return
    
    A = int(input_data[0])
    B = int(input_data[1])
    n = int(input_data[2])
    
    if A == 0:
        if B == 0:
            print(1)
        else:
            print("No solution")
        return
    
    if B % A != 0:
        print("No solution")
        return
    
    B //= A
    neg = B < 0
    if neg and n % 2 == 0:
        print("No solution")
        return
    
    if neg:
        B = -B
    
    for x in range(B + 1):
        if x ** n == B:
            print(-x if neg else x)
            return
    
    print("No solution")

if __name__ == "__main__":
    main()
