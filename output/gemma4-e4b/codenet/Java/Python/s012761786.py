import sys

def solve():
    # Read all input data from stdin
    input_data = sys.stdin.read().split()
    
    if len(input_data) < 3:
        # Handle case where input might be missing
        return

    # n, a, b are read as long integers in Java, standard Python int handles this.
    try:
        n = int(input_data[0])
        a = int(input_data[1])
        b = int(input_data[2])
    except ValueError:
        # Handle non-integer input
        return

    sa = abs(a - b)
    ans = 0

    if sa % 2 == 0:
        # Case 1: Difference is even
        ans = sa // 2
    else:
        # Case 2: Difference is odd
        
        # Calculate AAA = min(n - a, a - 1)
        AAA = min(n - a, a - 1)
        
        # Calculate BBB = min(n - b, b - 1)
        BBB = min(n - b, b - 1)

        # Initial ans calculation (min moves to an end)
        ans = min(AAA, BBB)

        # Adjust for odd difference: sa -> sa - 1 (even), ans += 1
        sa -= 1
        ans += 1

        # Final calculation: ans += (sa / 2)
        ans += sa // 2

    print(ans)

if __name__ == "__main__":
    solve()