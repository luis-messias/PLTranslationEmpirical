import sys

def solve():
    # Read the entire line from standard input
    try:
        line = sys.stdin.read().strip()
    except Exception:
        line = ""
    
    if not line:
        return

    tokens = line.split()
    stack = []

    for token in tokens:
        if token in ['+', '-', '*']:
            # Operator encountered
            if len(stack) < 2:
                # Should not happen with valid input, but handles insufficient operands
                break
            
            # Pop order: op2 (right operand), op1 (left operand)
            op2 = stack.pop()
            op1 = stack.pop()
            
            result = 0
            if token == '+':
                result = op1 + op2
            elif token == '-':
                result = op1 - op2
            elif token == '*':
                result = op1 * op2
            
            stack.append(result)
        else:
            # Number encountered
            try:
                number = int(token)
                stack.append(number)
            except ValueError:
                # Ignore tokens that are neither operators nor valid integers
                pass

    if stack:
        print(stack[0])

if __name__ == "__main__":
    solve()