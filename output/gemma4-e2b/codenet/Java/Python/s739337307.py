import sys

def solve():
    # Read all input tokens from stdin
    try:
        data = sys.stdin.read().split()
    except:
        return

    if not data:
        return

    if len(data) < 2:
        return

    # n = int(data[0]) # Not used
    m = int(data[1])
    
    map_data = {}
    countAc = 0
    countWaAll = 0
    
    data_index = 2
    
    for _ in range(m):
        if data_index + 1 >= len(data):
            break
            
        question = int(data[data_index])
        waOrAc = data[data_index + 1]
        data_index += 2
        
        if question not in map_data:
            if waOrAc == "WA":
                map_data[question] = 1
            else:  # AC
                map_data[question] = -1
                countAc += 1
        else:
            countWa = map_data[question]
            
            if waOrAc == "WA":
                # Increment the count