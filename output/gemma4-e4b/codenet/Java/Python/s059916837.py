def find(a, b):
    """Calculates the Hamming distance between two strings of equal length."""
    calc = 0
    for x in range(len(a)):
        if a[x] != b[x]:
            calc += 1
    return calc

def main():
    # Read S and T from standard input
    try:
        S = input()
        T = input()
    except EOFError:
        return

    len_s = len(S)
    len_t = len(T)

    # Initialize min_distance to infinity, representing Integer.MAX_VALUE
    min_distance = float('inf')

    # Iterate through all possible starting positions i
    # The loop runs up to len_s - len_t inclusive.
    for i in range(len_s - len_t + 1):
        # Get the substring of S of length len_t starting at i
        substring = S[i: i + len_t]
        
        # Calculate distance and update minimum
        distance = find(substring, T)
        min_distance = min(min_distance, distance)

    # Output logic
    # If min_distance is still infinity, it means no comparison was possible (S is shorter than T).
    if min_distance != float('inf'):
        print(min_distance)
    else:
        # Corresponds to the case where min remained Integer.MAX_VALUE in Java
        print(len_t)

if __name__ == "__main__":
    main()