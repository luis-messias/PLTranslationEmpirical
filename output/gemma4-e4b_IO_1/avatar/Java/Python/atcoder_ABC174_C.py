import sys

def solve():
    # Read K from standard input
    try:
        # Read the single integer input
        input_data = sys.stdin.read().strip()
        if not input_data:
            return None
        K = int(input_data)
    except Exception:
        return None

    # Java logic translation:
    # if ( K % 2 == 0 || K % 5 == 0 ) return - 1 ;
    if K % 2 == 0 or K % 5 == 0:
        return -1

    # if ( K % 7 == 0 ) K /= 7 ;
    if K % 7 == 0:
        K //= 7

    # K *= 9 ;
    K *= 9

    # Calculate the period of 1/K (Order of 10 modulo K)
    
    # If K is 1, the period is 1 (10^1 = 1 mod 1).
    if K == 1:
        return
