import sys

def solve():
    # Read all input lines
    input_data = sys.stdin.read().splitlines()
    
    if not input_data:
        return

    try:
        # The first line is N
        n = int(input_data[0])
        # The next N lines are the input strings
        str_list = input_data[1:n+1]
    except (ValueError, IndexError):
        # Handle cases where input might be malformed
        return

    mark = ["S", "H", "C", "D"]
    
    for ma in mark:
        for i in range(1, 14):
            s = str(i)
            st = f"{ma} {s}"
            
            # Check if the constructed string is NOT in the input list
            if st not in str_list:
                print(st)

if __name__ == "__main__":
    solve()