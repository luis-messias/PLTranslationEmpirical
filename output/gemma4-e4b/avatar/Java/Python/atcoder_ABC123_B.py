import sys

def solve():
    # Read all 5 integers from standard input
    try:
        data = sys.stdin.read().split()
        if not data:
            return
        a = [int(x) for x in data[:5]]
    except Exception:
        # Handle case where input might be missing or malformed
        return

    r = []
    map_data = {}

    # Step 1: Process input and build the map
    for i in range(len(a)):
        current_a = a[i]
        r_i = current_a % 10
        r.append(r_i)

        b = 10
        if r_i != 0:
            b = 10 - r_i
            # Using b as key, a[i] as value
            map_data[b] = current_a

    ans = 0

    # Step 2: Check if the map is empty (Case 1)
    if not map_data:
        # All numbers ended in 0
        ans = sum(a)
        print(ans)
        return

    # Step 3: Case 2 (Map is not empty)

    # Find the largest key (map.lastKey())
    max_key = max(map_data.keys())
    
    # Get the corresponding value (last = map.get(map.lastKey()))
    last = map_data[max_key]

    # Find the index of 'last' in 'a'
    # Note: Python's list.index() finds the first occurrence. 
    # The Java code iterates and assigns, effectively finding the index of the last match if duplicates exist, 
    # but since the logic only uses 'idx' to skip calculation for that specific index, 
    # finding the first index is usually sufficient unless the problem guarantees unique 'last' values.
    # We replicate the Java behavior of finding *an* index where a[i] == last.
    idx = -1
    for i in range(len(a)):
        if a[i] == last:
            idx = i
            
    # Calculate the sum
    for i in range(len(a)):
        if i != idx:
            current_a = a[i]
            r_i = r[i]
            
            if r_i == 0:
                ans += current_a
            else:
                # ans += a[i] + (10 - r[i])
                ans += current_a + (10 - r_i)
        
    # Add the contribution of 'last' (which was at index 'idx')
    ans += last
    
    print(ans)

solve()