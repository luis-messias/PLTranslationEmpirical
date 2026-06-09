import sys

def solve():
    # Read all input tokens from stdin
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    # The first element is N
    try:
        n = int(input_data[0])
    except ValueError:
        # Handle case where N might not be an integer if input is malformed
        return

    # Initialize counts for M, A, R, C, H
    # Indices: 0=M, 1=A, 2=R, 3=C, 4=H
    cnt = [0] * 5
    
    # Process the next N tokens (starting from index 1 in input_data)
    for i in range(n):
        if 1 + i >= len(input_data):
            break
        
        str_val = input_data[1 + i]
        
        if not str_val:
            continue
            
        char = str_val[0]
        
        if char == 'M':
            cnt[0] += 1
        elif char == 'A':
            cnt[1] += 1
        elif char == 'R':
            cnt[2] += 1
        elif char == 'C':
            cnt[3] += 1
        elif char == 'H':
            cnt[4] += 1

    # Calculate the result based on the 10 combinations of three distinct counts
    # M*A*R + M*A*C + M*A*H + M*R*C + M*R*H + M*C*H + A*R*C + A*R*H + A*C*H + R*C*H
    
    res = (
        cnt[0] * cnt[1] * cnt[2] +  # M*A*R
        cnt[0] * cnt[1] * cnt[3] +  # M*A*C
        cnt[0] * cnt[1] * cnt[4] +  # M*A*H
        cnt[0] * cnt[2] * cnt[3] +  # M*R*C
        cnt[0] * cnt[2] * cnt[4] +  # M*R*H
        cnt[0] * cnt[3] * cnt[4] +  # M*C*H
        cnt[1] * cnt[2] * cnt[3] +  # A*R*C
        cnt[1] * cnt[2] * cnt[4] +  # A*R*H
        cnt[1] * cnt[3] * cnt[4] +  # A*C*H
        cnt[2] * cnt[3] * cnt[4]    # R*C*H
    )
    
    print(res)

if __name__ == "__main__":
    solve()