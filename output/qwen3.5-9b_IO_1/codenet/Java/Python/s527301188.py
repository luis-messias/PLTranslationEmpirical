import sys

def main():
    try:
        line = input().split()
        nums = [0] * len(line)
        top = 0
        
        for s in line:
            if s in ['+', '-', '*']:
                top -= 1
                if s == '+':
                    nums[top - 1] = nums[top - 1] + nums[top]
                elif s == '-':
                    nums[top - 1] = nums[top - 1] - nums[top]
                elif s == '*':
                    nums[top - 1] = nums[top - 1] * nums[top]
            else:
                nums[top] = int(s)
                top += 1
        
        print(nums[0])
    except:
        pass

if __name__ == "__main__":
    main()
