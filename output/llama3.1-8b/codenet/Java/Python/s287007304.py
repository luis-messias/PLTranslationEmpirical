import sys

def main():
    input_str = input().split()
    a = int(input_str[0])
    b = int(input_str[1])

    if b % a == 0:
        print(a + b)
    else:
        print(b - a)

if __name__ == "__main__":
    main()