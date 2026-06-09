import sys

def main():
    input_data = sys.stdin.read().split()
    Q = int(input_data[0])
    H = int(input_data[1])
    S = int(input_data[2])
    D = int(input_data[3])
    N = int(input_data[4])
    
    onePrice = min(Q * 4, H * 2, S)
    
    if onePrice <= D / 2:
        print(N * onePrice)
    else:
        print((N // 2) * D + (N % 2) * onePrice)

if __name__ == "__main__":
    main()