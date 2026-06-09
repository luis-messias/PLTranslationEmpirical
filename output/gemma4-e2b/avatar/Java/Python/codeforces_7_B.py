import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    if not data:
        return

    s_ptr = 0
    
    # Read T and M
    try:
        t = int(data[s_ptr])
        s_ptr += 1
        m = int(data[s_ptr])
        s_ptr += 1
    except IndexError:
        return

    memory = [0] * m
    alloc_idx = 0

    for _ in range(t):
        if s_ptr >= len(data):
            break
            
        command = data[s_ptr]
        s_ptr += 1

        if command == "alloc":
            if s_ptr >= len(data): break
            n = int(data[s_ptr])
            s_ptr += 1
            
            # Check for contiguous free space of size n
            len_free = 0
            can_alloc = False
            start_index = -1
            
            for i in range(m):
                if memory[i] == 0:
                    len_free += 1
                else:
                    len_free =