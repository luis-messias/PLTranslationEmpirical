import sys

def str2list(s):
    """Converts a space-separated string of numbers into a list of integers."""
    return [int(x) for x in s.split()]

def solve():
    # Read all lines from standard input
    input_data = sys.stdin.read().splitlines()
    
    if len(input_data) < 3:
        return

    # N is on the first line
    try:
        n = int(input_data[0])
    except ValueError:
        return

    # V values are on the second line
    v_str = input_data[1]
    v_list = str2list(v_str)

    # C values are on the third line
    c_str = input_data[2]
    c_list = str2list(c_str)

    max_profit = 0
    
    # Calculate the total profit: sum of (V[i] - C[i]) where V[i] - C[i] > 0
    # We iterate over the minimum length of the two lists, assuming they are correctly sized.
    for v, c in zip(v_list, c_list):
        profit = v - c
        if profit > 0:
            max_profit += profit
            
    print(max_profit)

if __name__ == "__main__":
    solve()