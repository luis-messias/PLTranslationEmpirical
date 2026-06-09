import sys

def solve():
    # Read all input tokens
    try:
        data = sys.stdin.read().split()
        if not data:
            return
        s_str = data[0]
        t_str = data[1]
    except EOFError:
        return

    s_list = list(s_str)
    s_len = len(s_list)
    t_len = len(t_str)
    
    found_match = False
    
    # Iterate backwards for the starting index i
    for i in range(s_len - t_len, -1, -1):
        is_match = True
        
        # Check for match at position i
        for j in range(t_len):
            s_char = s_list[i + j]
            t_char = t_str[j]
            
            # Check if s_char is not '?' AND s_char does not match t_char
            if s_char != '?' and s_char != t_char:
                is_match = False
                break
        
        if is_match:
            found_match = True
            # Modify s_list in place
            for j in range(t_len):
                s_list[i + j] = t_str[j]
            
            # Since we found the match (and modified s_list), we break immediately
            break

    if found_match:
        result = []
        for char in s_list:
            if char == '?':
                result.append('a')
            else:
                result.append(char)
        print("".join(result))
    else:
        print("UNRESTORABLE")

solve()
