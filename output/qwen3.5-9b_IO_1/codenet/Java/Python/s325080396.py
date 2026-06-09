import sys

def main():
    input_data = sys.stdin.read().split()
    n = int(input_data[0])
    R = [int(x) for x in input_data[1:n+1]]
    
    maxv = R[1] - R[0]
    minv = R[0]
    for i in range(1, n):
        maxv = max(maxv, R[i] - minv)
        minv = min(minv, R[i])
    
    print(maxv)

if __name__ == "__main__":
    main()
