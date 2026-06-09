import sys

try:
    # Read all input and split by whitespace to get h and a
    data = sys.stdin.read().split()
    if len(data) >= 2:
        h = int(data[0])
        a = int(data[1])

        if a != 0:
            if h % a == 0:
                print(h // a)
            else:
                # This replicates the Java logic: h/a + 1 (where h/a is integer division)
                print(h // a + 1)
except Exception:
    # Handle potential errors during input reading
    pass
