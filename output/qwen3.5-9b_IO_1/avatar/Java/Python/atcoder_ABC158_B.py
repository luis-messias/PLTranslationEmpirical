import sys

def main():
    input_data = sys.stdin.read().split()
    N = int(input_data[0])
    A = int(input_data[1])
    B = int(input_data[2])
    
    if 1 <= N <= 10**18 and 0 <= A and 0 <= B and 0 < A + B and A + B <= 10**18:
        if A + B <= N:
            k = N // (A + B)
            remainder = N - k * (A + B)
            if remainder > A:
                print(A * k + remainder - (N - (k * (A + B) + A)))
            else:
                print(A * k + remainder)
        elif A + B > N and A <= N:
            print(A)
        else:
            print(N)

if __name__ == "__main__":
    main()
