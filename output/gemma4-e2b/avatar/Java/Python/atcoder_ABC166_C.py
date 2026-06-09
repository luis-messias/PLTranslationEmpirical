import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    # N is the first token
    N = int(data[0])
    # M is the second token
    M = int(data[1])
    
    # H values start from index 2
    H = []
    # ans values start from index 2
    ans = []
    
    # Read H values (N elements)
    for i in range(N):
        H.append(int(data[i + 2]))
        ans.append(True)
        
    data_idx = N + 2
    
    # Process M operations
    for _ in range(M):
        if data_idx + 1 >= len(data):
            break
            
        temp