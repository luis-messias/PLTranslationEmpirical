import sys

class AStationAndBus:
    def solve(self):
        # Read the input string from standard input
        try:
            s = sys.stdin.readline().strip()
        except:
            return

        # Check if both 'A' and 'B' are present in the string
        if "A" in s and "B" in s:
            print("Yes")
        else:
            print("No")

def main():
    solver = AStationAndBus()
    # The test number (1) is passed in Java but unused in the logic, 
    # so we just call solve.
    solver.solve()

if __name__ == "__main__":
    main()