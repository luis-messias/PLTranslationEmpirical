import sys

def solve():
    # Read all input tokens from standard input
    try:
        input_data = sys.stdin.read().split()
    except:
        return

    if not input_data:
        return

    # N is input_data[0], M is input_data[1]
    try:
        # N is read but unused in the logic
        M = int(input_data[1])
    except IndexError:
        return

    map_status = {}  # question_id -> count
    count_ac = 0
    count_wa_all = 0
    
    # Start processing pairs from index 2
    data_index = 2
    
    for i in range(M):
        if data_index + 1 >= len(input_data):
            break
            
        try:
            question