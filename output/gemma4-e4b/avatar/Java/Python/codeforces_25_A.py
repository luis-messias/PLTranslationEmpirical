import sys

def solve():
    # Read all input tokens from stdin
    data = sys.stdin.read().split()
    
    if not data:
        return

    # N is the first element
    n = int(data[0])

    even = 0
    odd = 0
    even_ind = 0
    odd_ind = 0

    # Iterate through the N elements provided. 
    # i represents the 1-based index (1 to N).
    # The value is stored at data[i].
    for i in range(1, n + 1):
        value = int(data[i])

        if value % 2 == 0:
            even += 1
            even_ind = i
        else:
            odd += 1
            odd_ind = i

    if odd > even:
        print(even_ind)
    else:
        print(odd_ind)

if __name__ == "__main__":
    solve()