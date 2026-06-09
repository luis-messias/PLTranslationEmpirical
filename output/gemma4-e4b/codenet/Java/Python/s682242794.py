import sys

class Main:
    def solve(self):
        # Read all tokens from standard input
        data = sys.stdin.read().split()
        
        # Process 7 pairs of (high, low)
        for i in range(0, 14, 2):
            if i + 1 >= len(data):
                break
            
            try:
                high = int(data[i])
                low = int(data[i+1])
                sa = high - low
                print(sa)
            except ValueError:
                # Stop if input is malformed
                break

def main():
    obj = Main()
    obj.solve()

if __name__ == "__main__":
    main()