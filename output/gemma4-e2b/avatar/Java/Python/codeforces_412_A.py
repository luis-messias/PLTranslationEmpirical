import sys

def solve():
    # Read all input tokens
    try:
        data = sys.stdin.read().split()
        if len(data) < 3:
            return
        
        n = int(data[0])
        k = int(data[1])
        a = data[2]
    except:
        # Handle case where input reading fails
        return

    if k > n / 2:
        # k > n/2
        while k < n:
            print("RIGHT")
            k += 1
    else:
        # k <= n/2
        while k > 1:
            print("LEFT")
            k -= 1

    if k == 1:
        # k == 1
        for i in range(len(a)):
            print("PRINT " + a[i])
            # if (i + 1) < a.length()
            if i + 1 < len(a):
                print("RIGHT")
    else:
        # k > 1
        # for ( int i = a.length() - 1 ; i >= 0 ; i -- )
        for i in range(len(a) - 1, -1, -1):
            print("PRINT " + a[i])
            # if (i - 1) >= 0
            if i - 1 >= 0:
                print("LEFT")

solve()