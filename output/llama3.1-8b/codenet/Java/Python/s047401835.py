import sys

def main():
    numbers = []
    n = int(input())

    for _ in range(n):
        numbers.append(int(input()))

    count = 0

    while True:
        numbers = [num // 2 for num in numbers if num % 2 == 0]
        if len(numbers) == n:
            count += 1
        else:
            break

    print(count)

if __name__ == "__main__":
    main()