import sys

def solve(d):
    """
    Calculates the sum based on the input integer d.
    The calculation is: sum(d * (i*d)^2) for i=1, 2, ... such that i*d < 600.
    """
    ans = 0
    i = 1
    while i * d < 600:
        x = i * d
        y = x * x
        ans += y * d
        i += 1
    return ans

def main():
    # Read all input tokens from standard input
    input_tokens = sys.stdin.read().split()
    
    # Process each token as a test case 'd'
    for d_str in input_tokens:
        try:
            d = int(d_str)
            print(solve(d))
        except ValueError:
            # Stop if input is not a valid integer
            break

if __name__ == "__main__":
    main()