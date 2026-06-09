import sys
import string

def solve():
    # Read S and T from standard input
    try:
        S = sys.stdin.readline().strip()
        T = sys.stdin.readline().strip()
    except EOFError:
        # Handle case where input might be empty
        return

    A = list(string.ascii_lowercase)
    res = True

    for s in A:
        s_idx = S.find(s)
        if s_idx < 0:
            continue

        # Get the character t from T at the first occurrence index of s in S
        t = T[s_idx]
        
        idx = 0
        while idx < len(S):
            # Find next occurrence of s in S starting from idx
            s_next_idx = S.find(s, idx)
            
            if s_next_idx >= 0:
                # Find next occurrence of t in T starting from idx
                t_next_idx = T.find(t, idx)
                
                if s_next_idx != t_next_idx:
                    res = False
                    break
                else:
                    # Move index past the found occurrence
                    idx = s_next_idx + 1
            else:
                # s not found in S starting from idx
                if t_next_idx >= 0:
                    # t found in T starting from idx
                    res = False
                    break
                else:
                    # Neither found, break the while loop
                    break
        
        if not res:
            break

    if res:
        print("Yes")
    else:
        print("No")

solve()