import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    # The first token is N
    try:
        n = int(data[0])
    except ValueError:
        return # Handle case where N is not an integer

    if len(data) < n + 1:
        # Not enough numbers provided
        return

    # The remaining tokens are the list of numbers
    list_of_numbers = [int(x) for x in data[1:n+1]]

    list_odd = []
    sum_even = 0

    # Separate even and odd numbers
    for x in list_of_numbers:
        if x % 2 == 0:
            sum_even += x
        else:
            list_odd.append(x)

    # Sort the odd numbers
    list_odd.sort()

    # Calculate the total sum (sum of evens + sum of odds)
    total_sum = sum_even
    for x in list_odd:
        total_sum += x

    # Apply the final adjustment
    # If the count of odd numbers is odd, subtract the smallest one
    if len(list_odd) % 2 != 0:
        total_sum -= list_odd[0]

    print(total_sum)

solve()