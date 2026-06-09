import sys

def solve():
    # Read all input from stdin
    input_data = sys.stdin.read().split()
    if not input_data:
        # Handle case where no input is provided
        print("0 0")
        return

    a = [int(x) for x in input_data]
    len_a = len(a)

    l = 0
    r = 0
    flag = False
    is_true = False

    # The loop structure mimics the Java 'loop:' label
    for i in range(len_a):
        # Check if the element is out of place (a[i] != i + 1)
        if a[i] != i + 1:
            if not flag:
                # First mismatch found
                l = i + 1
                flag = True
                continue
            else:
                # Second mismatch found
                r = i + 1