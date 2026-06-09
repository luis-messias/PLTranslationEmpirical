import sys

def solve():
    # Read all inputs from standard input
    try:
        data = sys.stdin.read().split()
        if not data:
            return
        
        Q = int(data[0])
        H = int(data[1])
        S = int(data[2])
        D = int(data[3])
        N = int(data[4])
    except Exception:
        return

    # Calculate onePrice: min(Q*4, H*2, S)
    onePrice = min(Q * 4, H * 2, S)

    # Check the condition: onePrice <= D / 2.0
    # Using integer arithmetic: onePrice * 2 <= D
    if onePrice * 2 <= D:
        print(N * onePrice)
    else:
        # (N // 2) * D + (N % 2) * onePrice
        result = (N // 2) * D + (N % 2) * onePrice
        print(result)

if __name__ == "__main__":
    solve()