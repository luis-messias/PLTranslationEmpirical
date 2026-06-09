import sys

def solve():
    # Read all tokens from standard input
    tokens = sys.stdin.read().split()
    
    for s in tokens:
        if s == "0":
            break
        
        total_sum = 0
        # Calculate the sum of digits
        for char in s:
            total_sum += int(char)
        
        print(total_sum)

if __name__ == "__main__":
    solve()