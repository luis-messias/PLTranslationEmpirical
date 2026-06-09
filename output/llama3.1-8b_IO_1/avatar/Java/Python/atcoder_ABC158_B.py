import sys
from math import pow

def main():
    N = int(input().split()[0])
    A = int(input().split()[0])
    B = int(input().split()[0])

    if 1 <= N and N <= pow(10, 18) and 0 <= A and 0 <= B and 0 < A + B and A + B <= pow(10, 18):
        if A + B <= N:
            k = N // (A + B)
            if N - k * (A + B) > A:
                print(A * k + (N - k * (A + B)) - (N - (k * (A + B) + A)))
            else:
                print(A * k + (N - k * (A + B)))
        elif A + B > N and A <= N:
            print(A)
        else:
            print(N)

if __name__ == "__main__":
    main()
