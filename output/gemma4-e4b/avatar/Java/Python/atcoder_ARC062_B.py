import sys

def solve():
    # Reading the input string S. Assuming the input consists of a single token/line.
    try:
        # Read the entire line and strip potential whitespace
        S = sys.stdin.readline().strip()
    except EOFError:
        return

    if not S:
        return

    score = 0
    
    for i in range(len(S)):
        # Determine 'my' character: 'g' if index i is even, 'p' if index i is odd.
        my = 'g' if i % 2 == 0 else 'p'
        
        # Get 'his' character from the input string S
        his = S[i]
        
        if my != his:
            # If they don't match:
            # If my is 'p', score increases by 1.
            # If my is 'g', score decreases by 1.
            if my == 'p':
                score += 1
            else: # my == 'g'
                score -= 1
                
    print(score)

if __name__ == "__main__":
    solve()