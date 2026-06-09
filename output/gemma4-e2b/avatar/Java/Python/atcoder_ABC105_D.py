import sys

def solve():
    # Read all input from stdin
    data = sys.stdin.read().split()
    
    if not data:
        return

    # The input reading logic in the Java code is complex due to the custom InputReader.
    # We assume the input follows the structure: N, M, followed by N elements of array A.
    
    # Since the Java code only runs one test case, we process the input sequentially.
    
    try:
        # Read N and M
        n = int(data[0])
        m = int(data[1])
        
        # Read array A
        a = [int(x) for x in data[2:2+n]]
        
    except IndexError:
        # Handle case where input might be incomplete
        return
    except ValueError:
        # Handle case where input is not integers
        return

    # --- Core Logic Translation ---
    
    dp = {}  # HashMap<Integer, Integer> dp
    ans = 0  # long ans
    base = 0  # int base

    for i in range(n):
        # 1. Calculate a[i] % m
        a_i_mod_m = a[i] % m
        
        # 2. Update base: base = (base - a[i] % m + m) % m
        # This ensures the result is always in [0, m-1]
        base = (base - a_i_mod_m + m) % m
        
        # 3. Calculate the key for the map: (base + a[i]) % m
        key = (base + a[i]) % m
        
        # 4. Update dp: dp.merge(key, 1, Integer::sum)
        # In Python, we use dict.get() or collections.defaultdict for merging counts.
        dp[key] = dp.get(key, 0) + 1
        
        # 5. Update ans: ans += dp.getOrDefault(base, 0)
        ans += dp.get(base, 0)

    # Output the result
    print(ans)

if __name__ == "__main__":
    solve()