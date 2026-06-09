import sys

def solve():
    # Read all input tokens from stdin
    # The Java code uses a custom iterator to read tokens separated by spaces and newlines.
    # We read all input and split it to get tokens.
    try:
        data = sys.stdin.read().split()
    except:
        # Handle case where input might be empty
        return

    if not data:
        return

    # The Java code reads tokens sequentially: N, then the list elements.
    
    # N is the first token
    try:
        N = int(data[0])
    except ValueError:
        return # Invalid input

    if N == 0:
        print(0)
        return

    # The list elements start from index 1
    if len(data) < N + 1:
        # Not enough data for the array
        return

    # Read the list of integers
    list_data = data[1:N+1]
    
    try:
        list_int = [int(x) for x in list_data]
    except ValueError:
        # Handle case where array elements are not integers
        return

    # --- Core Logic from solve() ---
    
    # The Java logic:
    # int N = nextInt();
    # ArrayList<Integer> list = nextIntArray();
    # int max = 0;
    # int output = 0;
    # for(int i = 0; i < N; i++){
    #   if(max <= list.get(i)){
    #     max = list.get(i);
    #     output++;
    #   }
    # }
    # myout(output);

    max_val = 0
    output = 0
    
    # Note: The Java code initializes max=0 and then checks if the current element is >= max.
    # This logic is slightly unusual for standard LIS, but we replicate it exactly.
    
    for x in list_int:
        if max_val <= x:
            max_val = x
            output += 1
            
    # myout(output);
    print(output)

if __name__ == "__main__":
    solve()