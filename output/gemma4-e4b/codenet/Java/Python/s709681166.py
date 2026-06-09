def main():
    import sys
    # Read the entire line of input
    try:
        s = sys.stdin.read().strip()
    except:
        s = ""

    result = []
    for char in s:
        if char.isupper():
            # Convert uppercase to lowercase
            result.append(char.lower())
        elif char.islower():
            # Convert lowercase to uppercase
            result.append(char.upper())
        else:
            # Keep other characters as is
            result.append(char)
    
    # Print the resulting string
    print("".join(result))

if __name__ == "__main__":
    main()