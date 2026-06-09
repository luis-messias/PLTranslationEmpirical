import sys

def main():
    input_data = sys.stdin.read().split()
    if not input_data:
        return
    
    iterator = iter(input_data)
    N = int(next(iterator))
    X = int(next(iterator))
    
    m = [0] * N
    m[0] = int(next(iterator))
    X -= m[0]
    min_val = m[0]
    
    for i in range(1, N):
        m[i] = int(next(iterator))
        X -= m[i]
        if m[i] < min_val:
            min_val = m[i]
    
    print(N + X // min_val)

if __name__ == "__main__":
    main()
