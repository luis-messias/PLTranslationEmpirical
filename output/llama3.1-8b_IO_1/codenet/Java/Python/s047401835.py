import sys

def main():
    numbers = []
    n = int(input())

    for _ in range(n):
        num_str = input()
        try:
            numbers.append(int(num_str))
        except ValueError:
            print("Invalid input. Please enter a number.")
            return

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
