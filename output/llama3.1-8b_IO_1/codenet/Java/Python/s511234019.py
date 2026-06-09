import sys

def main():
    a = int(input().split()[0])
    b = int(input().split()[0])

    if a % 2 == 0 or b % 2 == 0:
        print("No")
    else:
        print("Yes")

if __name__ == "__main__":
    main()
