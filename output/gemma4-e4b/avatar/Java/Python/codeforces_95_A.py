import sys

def solve():
    # Read all input tokens
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    # 1. Read N
    try:
        n = int(input_data[0])
    except IndexError:
        return

    # 2. Read N source strings (ss)
    ss = []
    current_index = 1
    for _ in range(n):
        if current_index < len(input_data):
            ss.append(input_data[current_index])
            current_index += 1
        else:
            # Handle case where input might be incomplete
            return

    # 3. Read target string (cc)
    if current_index < len(input_data):
        cc = input_data[current_index]
        current_index += 1
    else:
        return

    # 4. Read single character (c)
    if current_index < len(input_data):
        c = input_data[current_index]
    else:
        return

    # --- Helper function for comparison ---
    def compare(target_str, start_index, source_str, length):
        """
        Compares the substring of target_str starting at start_index 
        with the prefix of source_str of the same length, case-insensitively.
        Returns 0 if they match, non-zero otherwise.
        """
        if start_index + length > len(target_str) or length > len(source_str):
            return 1 # Indicate mismatch if lengths are wrong
        
        for k in range(length):
            char_target = target_str[start_index + k].upper()
            char_source = source_str[k].upper()
            if char_target != char_source:
                # Return non-zero difference (mimicking Java's a - b)
                return ord(char_target) - ord(char_source)
        return 0

    # --- Initialization ---
    m = len(cc)
    
    # Calculate replacement characters
    c_upper =