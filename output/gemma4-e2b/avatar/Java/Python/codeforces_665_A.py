import sys

def solve():
    # Read input lines
    try:
        # Read a and tA
        line1 = sys.stdin.readline().split()
        if not line1:
            return
        a = int(line1[0])
        tA = int(line1[1])

        # Read b and tB
        line2 = sys.stdin.readline().split()
        if not line2:
            return
        b = int(line2[0])
        tB = int(line2[1])

        # Read timing
        timing = sys.stdin.readline().strip()

    except Exception:
        # Handle potential errors during reading
        return

    # Parse timing (HHMM)
    # Java: int hrs = Integer.parseInt ( timing.substring ( 0 , 2 ) ) ;
    # Java: int mins = Integer.parseInt ( timing.substring ( 3 ) ) ;
    try:
        hrs = int(timing[0:2])
        mins = int(timing[3:])
    except ValueError:
        # Handle case where timing format is incorrect
        return

    # Calculate simulation times
    simDeparture = hrs * 60 + mins
    simArrival = simDeparture + tA

    counter = 0
    
    # Loop: for ( int i = 300 ; i < 1440 ; i += b )
    # range(start, stop, step)
    for i in range(300, 1440, b):
        busDeparture = i
        busArrival = i + tB
        
        # if ( busDeparture >= simArrival || simDeparture >= busArrival ) continue ;