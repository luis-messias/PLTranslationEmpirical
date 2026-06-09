import sys

def main():
    n = int(input())
    nums = list(map(int, input().split()))

    min_val = float('inf')
    count_negatives = 0
    total_sum = 0
    for num in nums:
        abs_num = abs(num)
        total_sum += abs_num
        min_val = min(min_val, abs_num)
        if num < 0:
            count_negatives += 1

    print(total_sum - (min_val * 2) if count_negatives % 2 != 0 else total_sum)

if __name__ == "__main__":
    main()
