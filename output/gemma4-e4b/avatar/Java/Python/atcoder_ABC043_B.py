import sys

class BUnhappyHackingABCEdit:
    """
    Implements the core logic of the problem.
    """
    def solve(self, test_number, s: str):
        """
        Processes the input string s.
        s: The input string containing '0', '1', and 'B'.
        """
        # Using a list as a stack/buffer (equivalent to StringBuilder append/pop)
        d = []
        for char in s:
            if char == '0' or char == '1':
                d.append(char)
            elif char == 'B':
                if d:
                    d.pop()
        
        print("".join(d))

def main():
    """
    Main function to handle input and execution.
    """
    # Read all input from stdin. Assuming the input is a single line string.
    try:
        # Read the entire input content and strip whitespace
        s = sys.stdin.read().strip()
    except Exception:
        s = ""

    solver = BUnhappyHackingABCEdit()
    # The test number is 1, and we pass the input string s.
    solver.solve(1, s)

if __name__ == "__main__":
    main()