import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    # The first token is N
    try:
        n = int(data[0])
    except ValueError:
        # Handle case where N is not a valid integer
        return

    if len(data) < n + 1:
        # Not enough elements provided
        return

    # The remaining tokens are the list elements
    list_arr = [int(x) for x in data[1:n+1]]

    # Collections.sort(list)
    list_arr.sort()

    # int c = 1
    c = 1

    # for ( int i = 0 ; i < n ; i ++ ) { if ( list.get ( i ) >= c ) { c ++ ; } }
    for x in list_arr:
        if x >= c:
            c += 1

    # pw.println ( c )
    print(c)

solve()