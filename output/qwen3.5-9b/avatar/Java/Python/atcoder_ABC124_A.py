import sys

def main():
    input_data = sys.stdin.read().split()
    a = int(input_data[0])
    b = int(input_data[1])
    sum = 0
    for _ in range(2):
        if a >= b:
            sum += a
            a -= 1
        else:
            sum += b
            b -= 1
    print(sum)

if __name__ == "__main__":
    main()