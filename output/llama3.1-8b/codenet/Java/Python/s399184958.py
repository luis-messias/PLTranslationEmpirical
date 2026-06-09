import sys

def main():
    A, B, C = map(int, input().split())
    if A == B and B == C and C == A:
        print("Yes")
    else:
        print("No")

if __name__ == "__main__":
    main()