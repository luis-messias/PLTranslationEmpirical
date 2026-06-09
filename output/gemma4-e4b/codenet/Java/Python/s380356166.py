import sys

class Solver:
    """
    Solves the problem: Find the number of triplets (X, Y, Z) such that
    X + Y + Z = S, and 0 <= X, Y, Z <= K.
    """
    def solve(self, in_stream, out_stream):
        # Read K and S from standard input
        try:
            # Assuming K and S are provided on separate lines or space-separated
            # We read all available input lines and assume the first two are K and S.
            input_data = sys.stdin.read().split()
            if len(input_data) < 2:
                # Handle case where input might be empty
                return 0
            
            K = int(input_data[0])
            S = int(input_data[1])
        except Exception:
            # Handle parsing errors if input format is unexpected
            return 0

        ans = 0
        
        # Iterate over possible values for X and Y
        for x in range(K + 1):
            for y in range(K + 1):
                # Calculate Z = S - X - Y
                z = S - x - y
                
                # Check if Z satisfies the constraints: 0 <= Z <= K
                if 0 <= z <= K:
                    ans += 1
        
        return ans

def main():
    """
    Main function to run the solver.
    """
    solver = Solver()
    
    # In Python, we typically pass standard streams or handle input reading globally.
    # We pass None/sys.stdin/sys.stdout to mimic the structure, but the Solver reads directly.
    result = solver.solve(sys.stdin, sys.stdout)
    
    print(result)

if __name__ == "__main__":
    main()