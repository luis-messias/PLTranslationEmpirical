import sys

def main():
    # Read N (the shift value)
    try:
        # Read the first line for N
        n_line = sys.stdin.readline().strip()
        if not n_line:
            return
        N = int(n_line)
    except ValueError:
        return

    # Read the string S (the characters to shift)
    try:
        # Read the second line for the string
        S = sys.stdin.readline().strip()
    except:
        S = ""

    result = []
    for char in S:
        # Check if the character is an uppercase letter
        if 'A' <= char <= 'Z':
            # Calculate 0-indexed position (A=0, B=1, ...)
            original_pos = ord(char) - ord('A')
            # Apply shift and wrap around 26
            new_pos = (original_pos + N) % 26
            # Convert back to character
            new_char = chr(new_pos + ord('A'))
            result.append(new_char)
        else:
            # Keep non-uppercase characters unchanged
            result.append(char)

    print("".join(result))

if __name__ == "__main__":
    main()