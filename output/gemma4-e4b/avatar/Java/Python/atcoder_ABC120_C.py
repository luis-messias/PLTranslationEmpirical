import sys

def solve_task_b(x: str) -> int:
    """
    Processes the string x using a stack to count alternating pairs ('10' or '01').
    """
    stack = []
    c = 0
    
    for char in x:
        stack.append(char)
        
        # Process the stack while there are at least two elements
        while len(stack) >= 2:
            # p is the top element, q is the second element
            p = stack.pop()
            q = stack.pop()
            
            # Check for alternating pattern
            if (p == '1' and q == '0') or (p == '0' and q == '1'):
                c += 1
                # Pair consumed, continue checking the remaining stack
                continue
            else:
                # No match, push back and stop processing the stack for this character
                stack.append(q)
                stack.append(p)
                break
                
    return c * 2

def main():
    # Reading input from stdin. Assuming the input string 'x' is provided as the first token.
    try:
        # Read all tokens from standard input and take the first one
        input_data = sys.stdin.read().strip()
        if not input_data:
            return
        
        # If the input is guaranteed to be a single string without spaces, use it directly.
        # If it's space-separated, we assume the first token is the string x.
        x = input_data.split()[0]
        
        result = solve_task_b(x)
        print(result)

    except Exception as e:
        # Handle potential EOF or reading errors gracefully
        pass

if __name__ == "__main__":
    main()