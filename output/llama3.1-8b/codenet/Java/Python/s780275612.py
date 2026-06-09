import math

def main():
    # Read input from user
    num = int(input())

    # Calculate cube of number and convert back to integer
    result = math.pow(num, 3)
    result = int(result)

    print(result)

if __name__ == "__main__":
    main()