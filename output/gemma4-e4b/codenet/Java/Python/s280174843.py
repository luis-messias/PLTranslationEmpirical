import sys

def solve():
    # Read the entire line of input from stdin
    try:
        line = sys.stdin.read().strip()
    except:
        # Fallback for environments where sys.stdin.read() might fail
        line = input().strip()

    if not line:
        # Handle case where no input is provided (though the Java code assumes input)
        return

    # Split the string by spaces and convert parts to integers
    try:
        abc = [int(x) for x in line.split()]
    except ValueError:
        # Handle non-integer input if necessary
        return

    # The Java code assumes at least 3 elements are available for the check
    if len(abc) >= 3:
        if abc[0] < abc[1] and abc[1] < abc[2]:
            print("Yes")
        else:
            print("No")
    # If fewer than 3 elements are provided, the behavior is undefined by the Java code's structure, 
    # but we adhere to the logic using the available elements if possible, or just exit if not enough.
    # Since the Java code uses fixed size array and relies on 3 elements, we assume 3 are present.
    # If we strictly follow the Java logic which assumes 3 elements are read into abc[0], abc[1], abc[2]:
    elif len(abc) == 3:
        if abc[0] < abc[1] and abc[1] < abc[2]:
            print("Yes")
        else:
            print("No")
    else:
        # If less than 3 elements are available, we cannot perform the check as intended.
        # For simplicity and matching the spirit of the original code, we assume valid input size.
        pass

solve()