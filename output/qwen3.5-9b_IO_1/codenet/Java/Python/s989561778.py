import sys

def main():
    input_data = sys.stdin.read().split()
    i = 0
    while i < len(input_data):
        a = int(input_data[i])
        b = int(input_data[i+1])
        digit = len(str(a + b))
        print(digit)
        i += 2

if __name__ == "__main__":
    main()
