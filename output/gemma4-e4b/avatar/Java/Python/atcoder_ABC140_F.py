import sys

def solve():
    # Read all input data from stdin
    data = sys.stdin.read().split()
    if not data:
        return

    # N is the first element
    N = int(data[0])
    
    # The remaining elements are the array S
    S = [int(x) for x in data[1:]]
    
    size = 1 << N
    
    # Check if the number of elements read matches the expected size
    if len(S) != size:
        # Handle potential input mismatch if necessary, though assuming valid input based on problem structure
        pass

    # spawned array initialization
    spawned = [False] * size
    
    # S is already populated
    
    # Initial setup: The largest element is always spawned
    # Since S is unsorted initially, we need to find the largest element's index 
    # or rely on the fact that the Java code sorts S immediately after reading.
    
    # Java code: Arrays.sort ( S )
    S.sort()
    
    # The largest element is now at S[size - 1]
    
    # active list initialization
    active = []
    
    # Add the largest element to active
    active.append(S[size - 1])
    
    # Mark the largest element as spawned
    spawned[size - 1] = True
    
    # Main loop: N iterations
    for _ in range(N):
        # Sort active list in descending order
        active.sort(reverse=True)
        
        activated = []
        next_idx = size - 1
        
        # Iterate through active slimes
        for slime in active:
            # Find the next available slot (next_idx)
            while next_idx >= 0 and (S[next_idx] >= slime or spawned[next_idx]):
                next_idx -= 1
            
            if next_idx < 0:
                print("No")
                return
            
            # Found a slot
            spawned[next_idx] = True
            activated.append(S[next_idx])
        
        # Update active list
        active.extend(activated)
        
    print("Yes")

if __name__ == "__main__":
    solve()