import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    if not data:
        return

    # The first element is N, the rest are the list elements
    try:
        n = int(data[0])
        if n == 0:
            print(0)
            return
        
        # Extract the list of numbers
        list_data = [int(x) for x in data[1:n+1]]
    except IndexError:
        # Handle case where input might be incomplete
        return

    odd = []
    sum_val = 0

    # First pass: calculate sum for evens, collect odds
    for i in list_data:
        if i % 2 == 0:
            sum_val += i
        else:
            odd.append(i)

    # Sort the odd numbers
    odd.sort()

    # Second pass: add all odd numbers to the sum
    for i in odd:
        sum_val += i

    # Check if the count of odd numbers is odd
    if len(odd) % 2 != 0:
        # Subtract the smallest odd number (which is at index 0 after sorting)
        sum_val -= odd[0]

    print(sum_val)

if __name__ == "__main__":
    solve()