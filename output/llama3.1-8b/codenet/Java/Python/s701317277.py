import sys

def main():
    N = int(input())
    A = [int(x) for x in input().split()]
    min_val = float('inf')
    count = 0
    total_sum = 0
    for num in A:
        if num < 0:
            count += 1
        min_val = min(min_val, abs(num))
        total_sum += abs(num)

    if count % 2 == 0:
        print(total_sum)
    else:
        print(total_sum - min_val * 2)

if __name__ == "__main__":
    main()