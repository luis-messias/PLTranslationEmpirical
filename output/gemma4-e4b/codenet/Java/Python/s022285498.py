import sys
from collections import defaultdict

class Task:
    """
    Handles the core logic of counting values based on the formula.
    """
    def solve(self, n: int):
        """
        Calculates the frequency of values V = x^2 + y^2 + z^2 + xy + xz + yz
        for 1 <= x, y, z <= 100, up to N.
        """
        # Use a dictionary (or array if N is small enough) to store counts.
        # Since N can be up to 100*100*3 = 30000, an array of size N+1 is fine.
        # The maximum value is when x=y=z=100: 3*100^2 + 3*100^2 = 60000.
        # Since N is read first, we only care about values <= N.
        
        # Initialize count array up to N.
        count_arr = [0] * (n + 1)

        for x in range(1, 101):
            for y in range(1, 101):
                for z in range(1, 101):
                    # Calculate V = x^2 + y^2 + z^2 + xy + xz + yz
                    value = x*x + y*y + z*z + x*y + x*z + y*z
                    
                    if value > n:
                        # Optimization: Since x, y, z are increasing, 
                        # if we break here, we assume the loops are structured 
                        # such that increasing z will only increase value.
                        # This break is only safe if the loops are structured 
                        # such that the value is monotonically increasing 
                        # with the innermost loop variable (z).
                        # Since x and y are fixed, increasing z increases value.
                        break
                    
                    count_arr[value] += 1

        # Output the counts for i = 1 to N
        for i in range(1, n + 1):
            print(count_arr[i])

def solve():
    """
    Main function to read input and execute the task.
    """
    # Read N from standard input
    try:
        # Reading the first integer N
        input_data = sys.stdin.read().strip()
        if not input_data:
            # Handle case where no input is provided
            return
        
        N = int(input_data)
    except EOFError:
        return
    except ValueError:
        # Handle case where input is not a valid integer
        return

    task = Task()
    task.solve(N)

if __name__ == "__main__":
    # The original Java code uses a complex thread setup, 
    # but functionally, we just need to call the solve logic.
    solve()