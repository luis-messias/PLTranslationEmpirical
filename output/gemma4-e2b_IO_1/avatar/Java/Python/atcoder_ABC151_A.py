import sys

def main():
    # Read the input line
    try:
        # Read the entire input, strip whitespace, and take the first character if available
        input_data = sys.stdin.read().strip()
        if not input_data:
            return
        
        s = input_data
        
        # The Java code calculates (s.charAt(0) + 1) and prints the character.
        # If s[0] is 'a', ord('a') + 1 is ord('b'), and chr(ord('b')) is 'b'.
        
        first_char = s[0]
        result_ord = ord(first_char) + 1
        print(chr(result_ord))
        
    except Exception:
        # Handle potential errors during reading/processing
        pass

if __name__ == "__main__":
    main()
