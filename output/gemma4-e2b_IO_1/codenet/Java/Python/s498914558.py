import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if len(data) < 2:
        return

    try:
        n = int(data[0])
        m = int(data[1])
    except ValueError:
        # Handle case where n or m are not valid integers
        return

    if len(data) < n + 2:
        # Not enough elements for po
        return

    # Extract the elements for po (starting from index 2)
    po = [int(x) for x in data[2:2+n]]

    # Replicate the logic: m -= po[i] for all i
    current_m = m
    for p_i in po:
        current_m -= p_i
    
    # The Java code updates m iteratively inside the loop.
    # Let's re-verify the Java loop structure:
    # for(int i=0;i<n;i++){
    #   po[i]=sc.nextInt();
    #   m-=po[i];
    # }
    # This means m is updated based on the values read sequentially.
    
    # Let's re-implement the loop based on the sequential reading of the input stream:
    
    # Resetting variables based on the sequential reading interpretation:
    
    # We need to re-read the input stream sequentially if we want to perfectly mimic
