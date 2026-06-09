import sys

def solve():
    # Read all tokens from standard input
    data = sys.stdin.read().split()
    if not data:
        return

    # N is the first element
    N = int(data[0])
    
    # x is the second element
    x = int(data[1])
    
    # Sweets are the remaining N elements
    sweet = [int(d) for d in data[2:2+N]]
    
    # Sort the sweets
    sweet.sort()

    # Simulate taking sweets
    num = 0
    for i in range(N):
        sweet_val = sweet[i]
        if x - sweet_val >= 0:
            x -= sweet_val
            num += 1
        else:
            break

    # Apply the specific adjustment condition
    if (num == N) and (x > 0):
        num -= 1

    print(num)

if __name__ == "__main__":
    solve()