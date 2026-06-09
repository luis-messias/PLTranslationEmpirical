import sys

def main():
    # Read all tokens from standard input
    input_data = sys.stdin.read().split()
    
    stack = []
    
    for token in input_data:
        try:
            a = int(token)
        except ValueError:
            # Skip non-integer tokens if they somehow appear
            continue
        
        if a == 0:
            # Corresponds to list.pop()
            if stack:
                # Pop from the front (index 0) to simulate Java's LinkedList pop()
                print(stack.pop(0))
        else:
            # Corresponds to list.push(a) (pushing to the head)
            stack.insert(0, a)

if __name__ == "__main__":
    main()