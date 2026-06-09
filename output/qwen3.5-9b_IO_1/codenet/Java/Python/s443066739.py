import sys

def main():
    input_data = sys.stdin.read().split()
    n = int(input_data[0])
    nums = [int(x) for x in input_data[1:n+1]]
    
    pre = [0] * (n + 1)
    for i in range(1, n + 1):
        pre[i] = pre[i-1] + nums[i-1]
    
    min_val = float('inf')
    
    for i in range(1, n):
        val1 = pre[i]
        val2 = pre[n] - pre[i]
        min_val = min(min_val, abs(val1 - val2))
    
    print(min_val)

if __name__ == "__main__":
    main()
