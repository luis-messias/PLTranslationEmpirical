import sys

# Set up input reading
def solve():
    # Read all lines from stdin
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    # N is the first element, S is the second
    try:
        n = int(input_data[0])
        s = input_data[1]
    except IndexError:
        # Handle case where input might be incomplete
        return

    def cal(s_str, c):
        """Calculates the parity of occurrences of character c in s_str 
        at indices i where (len(s_str) - 1) & i == i."""
        n_s = len(s_str)
        m = n_s - 1
        ans = 0
        
        # The condition (m & i) == i is always true for i < n_s if m = n_s - 1.
        # We only need to check s_str[i] == c.
        for i in range(n_s):
            if s_str[i] == c:
                # The original Java code uses XOR, which is equivalent to toggling a boolean/integer
                ans ^= 1
        return ans

    # Step 1: Build the difference string (sb)
    diff_list = []
    for i in range(1, n):
        # Calculate absolute difference of ASCII values
        diff = abs(ord(s[i]) - ord(s[i-1]))
        diff_list.append(str(diff))
    
    s_new = "".join(diff_list)

    # Step 2: Handle n == 2 case
    if n == 2:
        print(s_new[0])
        return

    # Step 3: Update s
    s = s_new

    # Step 4: Final calculation
    if "1" in s:
        result = cal(s, '1')
    else:
        result = cal(s, '2') * 2
    
    print(result)

if __name__ == "__main__":
    solve()