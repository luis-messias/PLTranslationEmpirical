import sys

def solve():
    # Read all input tokens and assume the first two are s and t
    input_data = sys.stdin.read().split()
    
    if len(input_data) < 2:
        return

    s = input_data[0]
    t = input_data[1]

    # A string t is a rotation of s if and only if they have the same length
    # and t is a substring of s concatenated with itself (s + s).
    
    if len(s) != len(t):
        print("No")
        return

    # Check if t is a rotation of s
    if t in (s + s):
        print("Yes")
    else:
        print("No")

solve()
