import sys

def main():
    input_data = sys.stdin.read().split()
    n = int(input_data[0])
    nums = [int(x) for x in input_data[1:n+1]]

    min_abs = float('inf')
    count_negatives = 0
    sum_abs = 0
    for num in nums:
        abs_num = abs(num)
        sum_abs += abs_num
        min_abs = min(min_abs, abs_num)
        if num < 0:
            count_negatives += 1

    if count_negatives % 2 == 0:
        print(sum_abs)
    else:
        print(sum_abs - (min_abs * 2))

if __name__ == "__main__":
    main()
