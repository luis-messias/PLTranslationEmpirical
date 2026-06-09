import math
import sys

def solve():
    # Read all four integers from standard input
    try:
        data = sys.stdin.read().split()
        if len(data) < 4:
            return
        A = int(data[0])
        B = int(data[1])
        H = int(data[2])
        M = int(data[3])
    except Exception:
        return

    # 1. Calculate angle contributions (in degrees)
    # Minutes contribution: M * 6 degrees
    mkaku = M * 6.0
    
    # Hours contribution: H * 30 + M * 0.5 degrees
    hkaku = H * 30.0 + M * 0.5
    
    # Angle difference (kaku)
    kaku = mkaku - hkaku
    
    # 2. Convert absolute angle difference to radians
    d_kaku = math.radians(abs(kaku))
    
    # 3. Calculate ans2 = (A^2 + B^2) - 2 * A * B * cos(d_kaku)
    
    # CC = A^2 + B^2
    cc = A*A + B*B
    
    # DD = 2 * A * B * cos(d_kaku)
    dd = 2.0 * A * B * math.cos(d_kaku)
    
    ans2 = cc - dd
    
    # 4. Final result: sqrt(ans2)
    ans = math.sqrt(ans2)
    
    print(ans)

if __name__ == "__main__":
    solve()