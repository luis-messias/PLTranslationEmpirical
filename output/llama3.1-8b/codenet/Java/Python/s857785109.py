import math

def main():
    n = int(input())
    if (n // 10) % 111 == 0 or n % 1000 % 111 == 0:
        print("Yes")
    else:
        print("No")

if __name__ == "__main__":
    main()