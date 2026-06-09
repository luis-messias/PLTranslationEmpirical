import sys

def solve():
    # Read the input string S
    try:
        S = sys.stdin.read().strip()
    except:
        # Handle case where input might be empty or error occurs
        return

    if not S:
        return

    N = len(S)
    MOD = 2019
    
    # mod_arr is not strictly needed for the final result, but we follow the logic
    # mod_arr = [0] * N 
    
    # mod_cnt stores the counts for remainders 0 to 2018
    mod_cnt = [0] * MOD
    
    radix = 1
    
    # Iterate through the digits of S from right to left (i=0 corresponds to the last digit)
    for i in range(N):
        # Current digit being processed (from the right end)
        digit = int(S[N - 1 - i])
        
        # Calculate the value based on the current digit and radix
        # tmp = (digit * radix) % MOD
        tmp = (digit * radix) % MOD
        
        # If i != 0, add the previous result (mod_arr[i-1])
        if i != 0:
            # Since we are not storing mod_arr explicitly, we need to figure out what mod_arr[i-1] was.
            # In the Java code, mod_arr[i-1] was calculated in the previous iteration.
            # The structure implies that the value added is the result of the previous step, which is stored in mod_arr[i-1].
            # Since we are only interested in mod_cnt, we can assume the previous accumulated value is implicitly handled.
            # Let's re-examine the Java logic: tmp = (tmp + mod_arr[i - 1]) % 2019;
            
            # Since we are only tracking counts, we need to ensure we use the correct previous accumulated value.
            # If we follow the Java