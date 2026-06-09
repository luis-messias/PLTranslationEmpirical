import sys

def maxLeft(n):
    return n - 2 if n > 2 else 0

def main():
    input_data = sys.stdin.read().split()
    t = int(input_data[0])
    for i in range(t):
        n = int(input_data[i + 1])
        print(maxLeft(n))

if __name__ == "__main__":
    main()