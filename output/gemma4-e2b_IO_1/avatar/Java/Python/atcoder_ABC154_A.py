import sys

def solve():
    # Read all input lines
    input_data = sys.stdin.read().splitlines()
    
    if len(input_data) < 3:
        # Handle case where input might be insufficient, though based on the problem structure, we expect 3 lines.
        return

    # Line 1: "red blue"
    line1 = input_data[0].strip()
    str_parts = line1.split()
    if not str_parts:
        return
    str0 = str_parts[0]

    # Line 2: "5 5"
    line2 = input_data[1].strip()
    try:
        a, b = map(int, line2.split())
    except ValueError:
        # Handle parsing error if necessary
        return

    # Line 3: "blue"
    line3 = input_data[2].strip()
    u = line3

    # Java logic: System.out.println (u.equals(str[0]) ? (a - 1) + " " + b : a + " " + (b - 1))
    if u == str0:
        result = str(a - 1) + " " + str(b)
    else:
        result = str(a) + " " + str(b - 1)
        
    print(result)

solve()
