import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    # a and b are the first two integers
    try:
        a = int(data[0])
        b = int(data[1])
    except IndexError:
        return

    # Initialize arrays (size 100001, indices 0 to 100000)
    # ju tracks if a number has been marked AC
    ju = [False] * 100001
    # pe tracks the count of WA cases for a number
    pe = [0] * 100001
    
    # Process the b test cases
    data_idx = 2
    for _ in range(b):
        if data_idx + 1 >= len(data):
            break
            
        n = int(data[data_idx])
        res = data[data_idx + 1]
        data_idx += 2
        
        # Java logic:
        # if(res.equals("WA") && ju[n-1] != true){ pe[n-1]++; }
        if res == "WA":
            # n is 1-indexed, array is 0-indexed
            if not ju[n - 1]:
                pe[n - 1] += 1
        
        # if(res.equals("AC")){ ju[n-1] = true; }
        if res == "AC":
            ju[n - 1] = True

    # Final calculation
    wa = 0
    ac = 0
    
    # Iterate up to a (the number of items to check)
    for i in range(a):
        if ju[i]:
            ac += 1
            wa += pe[i]
            
    print(f"{ac} {wa}")

solve()
