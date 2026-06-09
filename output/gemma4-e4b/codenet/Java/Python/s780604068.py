import sys

def solve():
    # Read all input tokens from stdin
    data = sys.stdin.read().split()
    
    if not data:
        print(0)
        return

    # N is the first element
    N = int(data[0])
    
    if N == 0:
        print(0)
        return

    # The 2N elements follow N
    # They are located from index 1 up to 2*N
    map_list = [int(x) for x in data[1:2*N + 1]]
    
    # Sort the list
    map_list.sort()
    
    max_sum = 0
    
    # Iterate over pairs (i, i+1)
    for i in range(0, 2 * N, 2):
        max_sum += min(map_list[i], map_list[i+1])
        
    print(max_sum)

if __name__ == "__main__":
    solve()