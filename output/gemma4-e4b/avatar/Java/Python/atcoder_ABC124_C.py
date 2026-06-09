import sys

class CColoringColorfully:
    def solve(self, x: str) -> int:
        """
        Calculates the minimum number of changes required based on forward and backward passes.
        """
        
        # --- Forward Pass (a1) ---
        # We use a list representation for mutable characters
        a = list(x)
        a1 = 0
        
        # Iterate from the second character (index 1)
        for i in range(1, len(a)):
            if a[i] == a[i-1]:
                # Flip a[i]
                if a[i] == '1':
                    a[i] = '0'
                else:
                    a[i] = '1'
                a1 += 1
        
        # --- Backward Pass (a2) ---
        b = list(x)
        a2 = 0
        
        # Iterate from the second to last character down to the second character (index 1)
        # The comparison is between b[i] and b[i-1], and the modification happens at b[i-1].
        for i in range(len(b) - 1, 0, -1):
            if b[i] == b[i-1]:
                # Flip b[i-1]
                if b[i-1] == '1':
                    b[i-1] = '0'
                else:
                    b[i-1] = '1'
                a2 += 1
                
        return min(a1, a2)

def main():
    # Reading input from stdin. Assuming the input is a single string token.
    try:
        # Read all input and split by whitespace, taking the first token
        input_data = sys.stdin.read().strip()
        if not input_data:
            return
        
        # Assuming the input is the string x
        x = input_data.split()[0]
        
        solver = CColoringColorfully()
        result = solver.solve(x)
        print(result)

    except Exception as e:
        # Handle potential EOF or reading errors gracefully
        pass

if __name__ == "__main__":
    main()