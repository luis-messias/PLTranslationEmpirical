import sys

def find(a, b):
    """Calculates the number of differing characters between two strings of equal length."""
    calc = 0
    # We assume len(a) == len(b) based on the context of the original problem
    for x in range(len(a)):
        if a[x] != b[x]:
            calc += 1
    return calc

def main():
    # Read S and T from standard input
    try:
        S = sys.stdin.readline().strip()
        T = sys.stdin.readline().strip()
    except:
        # Handle potential empty input gracefully if running interactively
        return

    if not S or not T:
        return

    min_diff = float('inf')
    len_T = len(T)

    # Iterate through all substrings of S that have the length of T
    for i in range(len(S) - len_T + 1):
        substring_S = S[i:i + len_T]
        diff = find(substring_S, T)
        min_diff = min(min_diff, diff)

    # Determine the output based on whether a valid minimum difference was found
    if min_diff != float('inf'):
        print(min_diff)
    else:
        # If no comparison was possible (e.g., S is shorter than T), print T's length
        print(len(T))

if __name__ == "__main__":
    main()