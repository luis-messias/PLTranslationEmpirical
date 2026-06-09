import sys

def main():
    i = 0
    input_data = sys.stdin.read().split()
    for i in range(1, 6):
        if i > len(input_data):
            break
        n = int(input_data[i-1])
        if n == 0:
            break
    print(i)

if __name__ == "__main__":
    main()
