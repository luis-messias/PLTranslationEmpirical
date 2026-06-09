import sys

def solve():
    # Read all input from stdin
    data = sys.stdin.read().split()
    
    if not data:
        return

    # N and K are the first two tokens
    n = int(data[0])
    k = int(data[1])
    s = data[2]

    # Initialize counts for 26 card types (A-Z)
    # We use a list of size 26 to store the counts (left values)
    cards = [0] * 26

    # Count occurrences of each character in S
    for char in s:
        index = ord(char) - ord('A')
        cards[index] += 1

    # The Java code structure suggests that the actual logic involves sorting 
    # and a specific greedy selection process related to K.
    
    # Since the Java code sorts the array of objects, we sort the list of counts.
    # The Java code sorts ascendingly based on 'left'.
    cards.sort()

    ans = 0
    
    # The loop structure in Java is complex due to the index manipulation (i += change - 1).
    # We need to replicate the effect of iterating K times and greedily selecting.
    
    # The Java code iterates K times, and in each iteration, it seems to try to extract 
    # items from the largest group (cards[25]) to satisfy the requirement K.
    
    # We need a mutable structure to track the counts as we extract items.
    # Since the Java code modifies cards[25].left and relies on sorting inside the loop,
    # we must ensure the sorting and selection logic is correctly translated.

    # Let's re-implement the selection logic based on the structure observed:
    
    # The loop iterates K times, and in each iteration, it tries to take 'change' items 
    # from the largest group (cards[25]) to satisfy the remaining requirement (k - i).
    
    # We will use a list of counts and simulate the process.
    
    # Note: The Java code uses i as the loop counter, and modifies it by jumping.
    # We will use a while loop or careful index management to replicate this.
    
    # Since the sorting happens inside the loop, we must re-sort every time.
    
    i = 0
    while i < k:
        # 1. Sort the current counts (this is crucial for finding the largest group)
        cards.sort()
        
        # 2. Determine how many items to take from the largest group (cards[25])
        # The amount to take is limited by the remaining requirement (k - i) 
        # and the available count in the largest group (cards[25].left).
        
        # Note: In the Java code, the index i refers to the iteration count (0 to k-1).
        # The Java code uses cards[25].left as the source.
        
        # The Java code uses: long change = Math.min ( cards [ 25 ].left , k - i ) ;
        
        change = min(cards[25], k - i)
        
        if change > 0: