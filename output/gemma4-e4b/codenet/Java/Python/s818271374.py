import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    # N is the first element
    N = int(data[0])
    
    # The numbers to process are the next N elements
    numbers = [int(x) for x in data[1:N+1]]
    
    count1 = 0
    count2 = 0
    
    for a in numbers:
        # count1: divisible by 4
        if a % 4 == 0:
            count1 += 1
        # count2: even, and (a/2) is odd.
        # This is equivalent to a = 4k + 2
        elif a % 2 == 0 and ((a // 2) % 2 == 1):
            count2 += 1
            
    # Check the conditions using integer division (//)
    if count1 >= N // 2:
        print("Yes")
    elif ((N // 2 - count1) * 2 + (N % 2)) == count2:
        print("Yes")
    else:
        print("No")

if __name__ == "__main__":
    solve()