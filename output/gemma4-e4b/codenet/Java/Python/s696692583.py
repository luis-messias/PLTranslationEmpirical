import sys

class Main:
    def __init__(self):
        # In Python, we don't need to explicitly initialize Scanner.
        # We will handle input reading in the run method.
        pass

    def tr(self, *os):
        # Equivalent to System.err.println(deepToString(os))
        print(os, file=sys.stderr)

    def run(self):
        # Read all integers from standard input
        try:
            data = [int(x) for x in sys.stdin.read().split()]
        except:
            data = []

        # Process data in chunks of three
        for i in range(0, len(data), 3):
            if i + 2 >= len(data):
                break

            my1 = data[i]
            my2 = data[i+1]
            enemy1 = data[i+2]

            # used array of size 11 (indices 0 to 10). We only care about 1 to 10.
            used = [False] * 11
            
            # Mark used numbers
            if 1 <= my1 <= 10:
                used[my1] = True
            if 1 <= my2 <= 10:
                used[my2] = True
            if 1 <= enemy1 <= 10:
                used[enemy1] = True

            all_count = 0
            safe_count = 0
            
            # Check numbers 1 through 10
            for j in range(1, 11):
                if not used[j]:
                    all_count += 1
                    # Check safety condition
                    if my1 + my2 + j <= 20:
                        safe_count += 1
            
            if safe_count * 2 >= all_count:
                print("YES")
            else:
                print("NO")

    def solve(self, a):
        # a is expected to be a list of lists (3x3 grid)
        s = ['d', 'o', 'x']