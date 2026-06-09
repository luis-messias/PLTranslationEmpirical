import sys

def solve():
    data = sys.stdin.read().split()
    if not data:
        return
    
    N = int(data[0])
    nums = [int(x) for x in data[1:N+1]]
    
    max_val = 0
    output = 0
    for num in nums:
        if max_val <= num:
            max_val = num
            output += 1
    
    print(output)

if __name__ == "__main__":
    solve()
