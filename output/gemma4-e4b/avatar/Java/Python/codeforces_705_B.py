import sys

def solve():
    # Read all input data from stdin and split it into tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    # The first element is N (the size of the array)
    try:
        N = int(data[0])
        # The remaining elements are the array contents
        arr = [int(x) for x in data[1:N+1]]
    except IndexError:
        # Handle case where input might be incomplete
        return

    prev_winner = 0
    
    for i in range(N):
        current_val = arr[i]
        
        if current_val == 1:
            if prev_winner == 0:
                prev_winner = 2
        
        # Case 1: prevWinner == 2 or prevWinner == 0
        if prev_winner == 2 or prev_winner == 0:
            # Check parity of (arr[i] - 1)
            if (current_val - 1) % 2 == 0:
                print(2)
                prev_winner = 2
            else:
                print(1)
                prev_winner = 1
        
        # Case 2: prevWinner == 1 (the 'else' block)
        else: # prev_winner == 1
            # Check parity of (arr[i] - 1)
            if (current_val - 1) % 2 == 0:
                print(1)
                prev_winner = 1
            else:
                print(2)
                prev_winner = 2

if __name__ == "__main__":
    # The Java code runs solve() once, regardless of the initial 't=1' loop structure.
    solve()