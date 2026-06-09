def solve():
    # Read Line 1 and get the first token
    try:
        line1 = input()
        str_0 = line1.split()[0]
    except EOFError:
        return

    # Read Line 2 (a and b)
    try:
        line2 = input()
        a, b = map(int, line2.split())
    except EOFError:
        return

    # Read Line 3 (u)
    try:
        u = input()
    except EOFError:
        return

    # Apply the logic
    if u == str_0:
        print(f"{a - 1} {b}")
    else:
        print(f"{a} {b - 1}")

solve()