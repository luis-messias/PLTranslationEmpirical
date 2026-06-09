import re

def main():
    in_str = input()
    nums = [i + 1 for i in range(int(in_str.split(',')[0]))]
    count = int(input())
    pattern = r"(\d+),(\d+)"
    line = []
    for _ in range(count):
        next_str = re.search(pattern, input()).groups()
        if len(next_str) == 2:
            line.append(int(next_str[0]) - 1)
            line.append(int(next_str[1]) - 1)
            nums[line[0]], nums[line[1]] = nums[line[1]], nums[line[0]]
    print(*nums)

if __name__ == "__main__":
    main()
