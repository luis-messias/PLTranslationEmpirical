import sys

def main():
    input_data = sys.stdin.read().split()
    idx = 0
    N = int(input_data[idx])
    idx += 1
    L = int(input_data[idx])
    idx += 1
    R = int(input_data[idx])
    idx += 1
    QL = int(input_data[idx])
    idx += 1
    QR = int(input_data[idx])
    idx += 1
    
    W = []
    for _ in range(N):
        W.append(int(input_data[idx]))
        idx += 1
    
    sum = [0] * (N + 1)
    for n in range(N):
        sum[n + 1] = sum[n] + W[n]
    
    min_val = float('inf')
    
    for firstR in range(N + 1):
        lCount = firstR
        rCount = N - lCount
        cand = sum[lCount] * L + (sum[N] - sum[lCount]) * R
        llCount = max(0, lCount - rCount - 1)
        rrCount = max(0, rCount - lCount - 1)
        cand += llCount * QL
        cand += rrCount * QR
        min_val = min(cand, min_val)
    
    print(min_val)

if __name__ == "__main__":
    main()
