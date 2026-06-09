import sys

def bubbleSort(a, n):
    count = 0
    flag = True
    while flag:
        flag = False
        for j in range(n - 1, 0, -1):
            if a[j] < a[j - 1]:
                # Swap
                a[j], a[j - 1] = a[j - 1], a[j]
                count += 1
                flag = True
    return count

def main():
    # Read all input lines
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    # The first element is n
    try:
        n = int(input_data[0])
    except ValueError:
        # Handle case where input might be malformed or empty
        return

    # The rest of the elements are the array a
    if len(input_data) < n + 1:
        # Not enough elements provided
        return
