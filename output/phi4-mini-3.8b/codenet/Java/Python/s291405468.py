import sys

def main():
    input_data = map(int, sys.stdin.read().split())
    first_number = next(input_data)
    second_number = next(input_data)

    print("Yes" if (first_number % 500) <= second_number else "No")

if __name__ == "__main__":
    main()