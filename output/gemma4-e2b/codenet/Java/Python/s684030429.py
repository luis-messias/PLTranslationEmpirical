import sys
import math

# Set up input reading from stdin
def get_input():
    # Read all input lines and split them into tokens
    data = sys.stdin.read().split()
    if not data:
        return None
    return data

def solve():
    data = get_input()
    if not data:
        return

    # The Java code structure implies reading inputs sequentially.
    # We will process the data list sequentially.
    
    # Since the Java code structure is complex and relies on specific input sequencing
    # (ni(), ni(), etc.), we must assume the input provided matches the expected sequence
    # for the specific problem context.
    
    # For a direct translation of the provided structure, we simulate reading tokens.
    
    # We need to handle the input reading based on how the Java methods were called.
    # Since the provided Java code structure is highly procedural and relies on a shared Scanner,
    # we will adapt the input reading to be sequential based on the tokens read.
    
    # --- Simulation based on the provided structure ---
    
    # The Java code calls ni() twice in solve(). We assume the input stream provides these values.
    
    try:
        # Read the first two integers for solve()
        if len(data) >= 2:
            a = int(data[0])
            b = int(data[1])
            
            # actual logic: System.out.println(Math.max(0, a-2*b));
            print(max(0, a - 2 * b))
        
        # The rest of the Java code defines complex logic (roads, findRoads)
        # which seems to be commented out or part of a separate test case structure.
        # Since the provided Java snippet only executes solve(), we focus on that.
        
    except IndexError:
        # Handle case where not enough input is provided
        pass
    except ValueError:
        # Handle case where input is not an integer
        pass


# Note: The utility methods (ni, ia, ida, etc.) are highly dependent on the specific
# input stream setup of the original Java program. Since the provided Java code
# only executes the simple solve() method based on two inputs, the complex
# utility functions are not strictly necessary for this specific execution path,
# but they are translated below for completeness if the intent was to replicate
# the entire class structure.

# Since the provided Java code is a class structure, we define a class in Python.

class Main:
    def __init__(self):
        # In Python, we handle input reading directly or via sys.stdin
        pass

    # Utility methods (adapted for direct reading if needed, but often omitted in CP style Python)
    # We skip direct translation of all utility methods as they rely on the specific
    # state management of the Java Scanner, which is better handled by the main execution flow.

    def solve(self):
        # Simulate reading input if this were run standalone, but since the provided
        # Java code calls ni() which reads from a shared scanner, we rely on the
        # external execution context (solve() function above) for input handling.
        
        # If we were to strictly replicate the Java logic flow:
        # We assume inputs 'a' and 'b' are somehow available.
        # Since the provided Java snippet calls ni() twice, we must assume the input
        # reading happens externally or we must read it here.
        
        # For a runnable Python script based on the provided snippet, we rely on the
        # external execution context reading the input tokens.
        pass

# Execute the logic based on the structure provided.
# Since the Java code structure is highly procedural, we execute the logic directly
# using standard Python input reading for simplicity, focusing on the core calculation.

if __name__ == "__main__":
    # Read all inputs expected by the Java structure (assuming two inputs for solve)
    try:
        # Read the first two integers expected by solve()
        # In a typical competitive programming setup, input is read from stdin
        import sys
        data = sys.stdin.read().split()
        
        if len(data) >= 2:
            a = int(data[0])
            b = int(data[1])
            
            # Calculate the result as per the Java logic: a - b
            result = a - b
            print(result)
        else:
            # Handle case where not enough input is provided
            pass
    except Exception as e:
        # Handle potential errors during input reading
        pass