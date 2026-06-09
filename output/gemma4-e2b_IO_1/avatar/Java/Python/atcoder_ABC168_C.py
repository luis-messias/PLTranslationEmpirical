import math
import sys

def solve():
    # Read input from stdin
    try:
        # Read all inputs and convert to integers
        data = sys.stdin.read().split()
        if len(data) < 4:
            return
        A = int(data[0])
        B = int(data[1])
        H = int(data[2])
        M = int(data[3])
    except Exception:
        return

    # Calculate kaku based on the Java logic:
    # mkaku = M * 6
    mkaku = M * 6.0

    # hkaku = H * 30 + M / 2
    hkaku = H * 30 + M / 2.0

    # kaku = mkaku - hkaku
    kaku = mkaku - hkaku

    # dkaku = | radians(kaku) |
    dkaku = math.fabs(math.radians(kaku))

    # AA2 = A*A, BB2 = B*B, CC = AA2 + BB2
    AA2 = A * A
    BB2 = B * B
    CC = AA2 + BB2

    # DD = cos(dkaku) * 2 * A * B
    # DD = cos(dkaku) * 2 * A * B
    DD = math.cos(dkaku) * 2 * A * B

    # ans2 = CC - DD
    ans2 = CC - DD

    #
