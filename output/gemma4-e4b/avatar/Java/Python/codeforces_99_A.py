s = input()
try:
    dot_index = s.index('.')
except ValueError:
    # Should not happen based on problem constraints, but handles missing dot
    exit()

# Check 1: Previous character is '9'
if dot_index > 0 and s[dot_index - 1] == '9':
    print("GOTO Vasilisa.")
# Check 2: Number after dot > 4
elif dot_index < len(s) - 1:
    suffix = s[dot_index + 1:]
    try:
        suffix_val = int(suffix)
        
        if suffix_val > 4:
            prefix = s[:dot_index]
            # Python handles large integers automatically, replacing BigInteger
            print(int(prefix) + 1)
        else:
            # Default case: print prefix
            print(s[:dot_index])
    except ValueError:
        # If suffix is not a valid integer (e.g., empty string if dot is last char, though checked above)
        # Fall through to the default case (printing prefix)
        print(s[:dot_index])
else:
    # This handles cases where the dot is at the end, or the previous checks failed
    print(s[:dot_index])