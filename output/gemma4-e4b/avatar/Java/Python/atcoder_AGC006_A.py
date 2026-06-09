import sys

def get_fail(s: str) -> list[int]:
    """
    Calculates the KMP prefix function (failure function) for string s.
    Returns a list where result[i] is the length of the longest proper 
    prefix of s[0...i] that is also a suffix of s[0...i].
    """
    m = len(s)
    if m == 0:
        return []
    
    f = [0] * m
    length = 0  # length of the previous longest prefix suffix
    
    for i in range(1, m):
        # This loop implements the core logic: fall back using the failure function
        while length > 0 and s[i] != s[length]:
            length = f[length - 1]
        
        if s[i] == s[length]:
            length += 1
        
        f[i] = length
    return f

def solve():
    # Read all input from stdin
    try:
        data = sys.stdin.read().split()
    except EOFError:
        return

    if not data:
        return

    # Input reading based on the Java structure: n, s1, str
    try:
        n = int(data[0])
        s1 = data[1]
        str_s = data[2] # Renamed 'str' to avoid conflict with built-in type
    except IndexError:
        # Handle case where not enough input is provided
        return

    # Construct the combined string S = str_s + s1
    combined_s = str_s + s1
    
    # Calculate the failure function for the combined string
    f = get_fail(combined_s)
    
    # The length of the combined string is 2 * n
    total_len = 2 * n
    
    # The failure function f[total_len - 1] gives the length of the longest 
    # proper prefix of combined_s that is also a suffix.
    # The Java code calculates: len = min(f[cnt], min(n, n))
    # Since f is 0-indexed and has length 2n, the last element is f[2n-1].
    
    if total_len == 0:
        # Should not happen given constraints, but safe check
        print(0)
        return

    # f[total_len - 1] is the value corresponding to f[cnt] in the Java code
    overlap_len = f[total_len - 1]
    
    # The constraint is min(overlap_len, n)
    # Since n is the length of s1 and str_s, the overlap cannot exceed n.
    len_overlap = min(overlap_len, n)
    
    # Output: 2 * n - len
    result = 2 * n - len_overlap
    print(result)

if __name__ == "__main__":
    solve()