import sys

class Main:
    """
    A class replicating the structure and functionality of the original Java class.
    """
    def __init__(self):
        # Initialization can be empty if no state needs to be maintained
        pass

    def ni(self):
        """Reads an integer from standard input."""
        try:
            # Read line and strip whitespace, then convert to int
            return int(sys.stdin.readline().strip())
        except:
            # Return a default value or raise an error if input fails
            return 0

    def solve(self):
        """
        Executes the main logic: reads two integers (a and b) and prints a - 2*b.
        """
        # Read the first integer (a)
        a = self.ni()
        
        # Read the second integer (b)
        b = self.ni()
        
        # Calculate and print the result
        result = a - 2 * b
        print(result)

    # --- Utility methods (kept for structural completeness, though not used in solve) ---

    def si(self):
        """Reads a string from standard input."""
        return sys.stdin.readline().strip()

    def mi(self):
        """Reads a float from standard input."""
        try:
            return float(sys.stdin.readline().strip())
        except:
            return 0.0

    def di(self):
        """Reads a double from standard input."""
        try:
            return float(sys.stdin.readline().strip())
        except:
            return 0.0

    def ci(self):
        """Reads a character from standard input."""
        return sys.stdin.readline().strip()

    def bi(self):
        """Reads a boolean from standard input."""
        return sys.stdin.readline().strip().lower() == 'true'

    def gi(self):
        """Reads a generic type from standard input."""
        return sys.stdin.readline().strip()

# Main execution block
if __name__ == "__main__":
    # Instantiate the class
    main_instance = Main()
    
    # Execute the primary function
    # Note: This assumes the input stream provides two integers sequentially.
    main_instance.solve()
