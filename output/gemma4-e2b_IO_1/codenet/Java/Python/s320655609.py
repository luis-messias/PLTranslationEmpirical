import sys

def main():
    # Read all input data
    data = sys.stdin.read().split()
    
    if not data:
        return

    try:
        N = int(data[0])
    except ValueError:
        return

    if len(data) < 6:
        return

    constraints = []
    # Read the 5 constraints starting from index 1
    for i in range(1, 6):
        try:
            constraints.append(int(data[i]))
        except ValueError:
            # Stop if input is not an integer
            return

    if not constraints:
        return

    # Find the minimum constraint
    min_c = min(constraints)

    # Calculate time based on the logic: ceil(N / min_c) + 4
    
    # Calculate ceil(N / min_c)
    # Equivalent to (N + min_c - 1) // min_c for positive integers
    # Or using the explicit check from the Java code:
