import sys

# Set up input reading for efficiency
def input():
    return sys.stdin.readline().strip()

def get_value_at_index(index: int) -> int:
    """Calculates 1 + ( ( index - 1 ) * index / 2 )"""
    # Use integer division //
    return 1 + ((index - 1) * index) // 2

def solve():
    """
    Reads the target position and calculates the required value based on the sequence logic.
    """
    try:
        # Read the position (Java used nextLong(), Python uses int())
        position_str = input()
        if not position_str:
            return
        position = int(position_str)
    except EOFError:
        return
    except ValueError:
        return

    # 1. Find nrstSeqStartIndx
    nrst_seq_start_indx = 1

    # First while loop: while ( getValueAtIndex ( nrstSeqStartIndx * 2 ) < position )
    while get_value_at_index(nrst_seq_start_indx * 2) < position:
        nrst_seq_start_indx *= 2

    # Second while loop: while ( getValueAtIndex ( nrstSeqStartIndx + 1 ) <= position ) nrstSeqStartIndx ++ ;
    while get_value_at_index(nrst_seq_start_indx + 1) <= position:
        nrst_seq_start_indx += 1

    # 2. Calculate result
    start_index = get_value_at_index(nrst_seq_start_indx)
    result = (position - start_index) + 1
    
    print(result)

if __name__ == "__main__":
    solve()