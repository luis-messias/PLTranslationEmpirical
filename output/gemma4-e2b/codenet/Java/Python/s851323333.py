import sys

def main():
    # Read all input tokens from stdin
    input_data = sys.stdin.read().split()
    stack = []

    for token in input_data:
        try:
            a = int(token)
            if a == 0:
                # list.pop() removes and returns the last element (LIFO behavior)
                if stack:
                    print(stack.pop())
            else:
                # list.push(a) adds the element (append for stack behavior)
                stack.append(a)
        except ValueError:
            # Ignore non-integer input if any
            continue

if __name__ == "__main__":
    main()