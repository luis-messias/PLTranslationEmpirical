import sys

def main():
    input_data = sys.stdin.read().split()
    n = int(input_data[0])
    d = int(input_data[1])
    nums = [int(input_data[i + 2]) for i in range(n)]
    
    result = 0
    for i in range(1, n):
        a = nums[i - 1] - nums[i]
        if a >= 0:
            result += a // d + 1
            nums[i] += (a // d + 1) * d
    
    print(result)

if __name__ == "__main__":
    main()
