import sys

def solve():
    # Read all input from stdin
    # Reading all input and splitting handles N, K, and S
    try:
        data = sys.stdin.read().split()
    except:
        return

    if len(data) < 3:
        return

    # N and K are the first two tokens
    n = int(data[0])
    k = int(data[1])
    s = data[2]

    # Initialize counts for 26 card types (A-Z)
    # The Java code uses objects implementing Comparable, but here we just need counts.
    # We will use a list of integers for simplicity, as the comparison logic is based on 'left'.
    cards = [0] * 26

    # Count occurrences of each character in S
    for char in s:
        index = ord(char) - ord('A')
        if 0 <= index < 26:
            cards[index] += 1

    # The Java code initializes cards[i].left = 0.
    # We need to simulate the structure where we sort the counts repeatedly.
    
    # The Java code uses a structure where cards[i] is an object with a 'left' field.
    # Since we only care about the counts for sorting and manipulation, we can work directly with the list of counts.
    
    # The Java code sorts the array of objects. Since the objects only contain 'left', sorting the list of counts is equivalent.
    
    # We must ensure that the sorting mechanism reflects the Java structure where the sorting is based on the 'left' property.
    
    # Since the Java code uses a custom class, we simulate the sorting of the counts directly.
    
    # The Java code sorts the array of 26 objects.
    cards.sort()

    ans = 0
    
    # Replicating the complex loop structure:
    # for ( int i = 0 ; i < k ; i ++ ) { ... i += change - 1 ; }
    
    # We use a while loop to manage the iteration based on the remaining requirement k.
    i = 0
    while i < k:
        # 1. Sort the current counts (necessary because the selection modifies the largest group)
        cards.sort()
        
        # 2. Determine how many items to take from the largest group (cards[25])
        # Java: long change = Math.min ( cards [ 25 ].left , k - i ) ;
        
        # cards[25] is the largest count. k - i is
