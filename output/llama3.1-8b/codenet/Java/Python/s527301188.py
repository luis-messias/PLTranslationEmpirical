import sys

def main():
    input_str = input().split()
    nums = []
    top = 0

    for s in input_str:
        if s[0] == '+':
            top -= 1
            nums[top-1] += nums[top]
        elif s[0] == '-':
            top -= 1
            nums[top-1] -= nums[top]
        elif s[0] == '*':
            top -= 1
            nums[top-1] *= nums[top]
        else:
            nums.append(int(s))
            top += 1

    print(nums[0])

if __name__ == "__main__":
    main()