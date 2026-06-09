import sys

def solve():
    # Read all lines from standard input
    input_lines = sys.stdin.read().splitlines()
    
    if not input_lines:
        return

    # The first line contains N and M
    try:
        n_m = input_lines[0].split()
        if len(n_m) < 2:
            return
        N = int(n_m[0])
        M = int(n_m[1])
    except ValueError:
        return

    # The next N lines are the input strings
    input_strings = input_lines[1:N+1]
    
    results = []
    
    for i in range(N):
        if i >= len(input_strings):
            # Should not happen if input matches N, but safe guard
            break
            
        str_input = input_strings[i]
        temp = []
        
        for j in range(M):
            if j >= len(str_input):
                # Should not happen if input strings are length M
                break
                
            if str_input[j] == '-':
                temp.append('-')
            else:
                # Check parity of i + j
                if (i + j) % 2 == 1:
                    temp.append('W')
                else:
                    temp.append('B')
        
        results.append("".join(temp))

    # Print results
    for result in results:
        print(result)

if __name__ == "__main__":
    solve()