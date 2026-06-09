import sys

def is_even_string(s: str) -> bool:
    """Checks if the first half of the string equals the second half."""
    n = len(s)
    if n % 2 != 0:
        # If length is odd, the definition of the halves is ambiguous based on the Java code's logic (s.length()/2).
        # We follow the Java logic: a = s.substring(0, s.length()/2), b = s.substring(s.length()/2)
        # For odd length N, N/2 is floor(N/2).
        mid = n // 2
        a = s[:mid]
        b = s[mid:]
    else:
        # If length is even
        mid = n // 2
        a = s[:mid]
        b = s[mid:]

    return a == b

def main():
    # Read input from stdin
    try:
        S = sys.stdin.readline().strip()
    except EOFError:
        return

    if not S:
        return

    # Initial string manipulation based on Java logic
    if len(S) % 2 == 1:
        # If length is odd, remove the last character
        S = S[:-1]
    else:
        # If length is even, remove the last two characters
        S = S[:-2]

    # Iterative shortening loop
    # The loop continues as long as S has length > 0.
    # In each step, S is shortened by 2 characters (S = S.substring(0, S.length() - 2))
    while len(S) > 0:
        if is_even_string(S):
            break
        
        # Shorten S by 2 characters for the next iteration
        S = S[:-2]

    # Output the final length
    print(len(S))

if __name__ == "__main__":
    main()