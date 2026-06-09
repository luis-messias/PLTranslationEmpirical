import sys

def main():
    count = int(input())
    giving_numbers = [int(input()) for _ in range(count)]

    # Reversing Numbers
    for num in reversed(giving_numbers):
        print(num, end=' ')
    print()

if __name__ == "__main__":
    main()