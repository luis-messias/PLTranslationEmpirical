import sys

# Set recursion limit higher for deep DFS calls
# The maximum depth is N, which can be up to M.
sys.setrecursionlimit(2000)

# Global variables to store state
a = []
b = []
c = []
d = []
n = 0
m = 0
q = 0
ans = -float('inf')

def dfs(list_sequence):
    global ans
    global n, m, q, a, b, c, d

    # Base Case: Sequence length reached N
    if len(list_sequence) == n:
        score = 0
        for i in range(q):
            # Check the condition: list[b[i]] - list[a[i]] == c[i]
            # Note: a[i] and b[i] are 0-based indices already.
            if list_sequence[b[i]] - list_sequence[a[i]] == c[i]:
                score += d[i]
        ans = max(ans, score)
        return

    # Recursive Step
    if not list_sequence:
        # First element: range 1 to M
        start_num = 1
    else:
        # Subsequent elements: range from the last element to M (non-decreasing sequence)
        start_num = list_sequence[-1]

    for num in range(start_num, m + 1):
        # Optimization: If we already reached N, we don't need to proceed, 
        # but the base case handles this check implicitly.
        
        # Add number and recurse
        list_sequence.append(num)
        dfs(list_sequence)
        # Backtrack
        list_sequence.pop()

def solve():
    global n, m, q, a, b, c, d, ans
    
    # Read all input from stdin
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    data_index = 0
    
    # Read N, M, Q
    n = int(input_data[data_index])
    m = int(input_data[data_index + 1])
    q = int(input_data[data_index + 2])
    data_index += 3

    # Initialize arrays
    a = [0] * q
    b = [0] * q
    c = [0] * q
    d = [0] * q

    # Read constraints
    for i in range(q):
        # a[i] and b[i] are 1-based in input, convert to 0-based
        a[i] = int(input_data[data_index]) - 1
        b[i] = int(input_data[data_index + 1]) - 1
        c[i] = int(input_data[data_index + 2])
        d[i] = int(input_data[data_index + 3])
        data_index += 4

    # Start DFS
    dfs([])

    # Output the result
    print(ans)

if __name__ == "__main__":
    solve()