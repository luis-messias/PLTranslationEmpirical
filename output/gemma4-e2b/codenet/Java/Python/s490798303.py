import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    # Input parsing based on the sequential reading pattern
    try:
        n = int(data[0])
        k = int(data[1])
    except IndexError:
        return

    map_data = {}
    data_index = 2

    for _ in range(k):
        if data_index >= len(data):
            break
            
        try:
            d = int(data[data_index])
            data_index += 1
        except ValueError:
            break
        
        for _ in range(d):
            if data_index >= len(data):
                break
            
            try:
                person = int(data[data_index])
                data_index += 1
            except ValueError:
                break
            
            if person not in map_data:
                map_data[person] = []
            
            # Store d associated with person, mirroring the Java logic
            map_data[person].append(d)

    # Count how many numbers from 1 to n are missing from the map keys
    count = 0
    for i in range(1, n + 1):
        if i not in map_data:
            count += 1

    print(count)

solve()