import sys
import math

# Set recursion limit higher for safety
# sys.setrecursionlimit(2000)

# Global variables mimicking static class members in Java
ans = 0
balls = []
N = 0
taken = []

def solve():
    """
    Calculates the minimum maximum length of the arithmetic progression found 
    by fixing the first two points (balls[0] and balls[add]).
    """
    global ans
    
    # Iterate through all possible second points (add > 0)
    for add in range(1, N):
        # Reset taken array for each pair (p, q)
        global taken
        taken = [False] * N
        
        # Calculate the difference vector (p, q)
        p = balls[add][0] - balls[0][0]
        q = balls[add][1] - balls[0][1]
        
        # Update ans with the minimum result found
        ans = min(ans, check(p, q))

def check(p, q):
    """
    Checks the maximum length of the arithmetic progression defined by (p, q) 
    starting from the first available point.
    """
    global N
    global taken
    taken = [False] * N
    ret = 0
    
    # The loop continues as long as we can find an untaken starting point
    while True:
        added = False
        start_index = -1
        x, y = -1, -1  # Coordinates of the current point
        
        # Find the first available point (the starting point for this sequence)
        for i in range(len(balls)):
            if not (balls[i][0] == 0 and balls[i][1] == 0): # Assuming 0,0 is a placeholder if needed, but here we just check if it's available
                # Since we are iterating through the list, the first available point is the start.
                # We must ensure we only count points that haven't been used in previous sequences.
                # Since 'taken' status is implicit in the loop structure, we just need to find the first available point.
                
                # A simpler approach: iterate and find the first available point (i)
                # and then try to build the sequence from there.
                
                # To correctly model the greedy selection: find the smallest index i such that balls[i] is unused.
                # If we use a separate 'used' array, it would be cleaner.
                
                # Let's assume the input list 'balls' is the source of points, and we need to track usage.
                # Since the problem context implies a single pass greedy selection, we iterate through indices.
                
                # Re-implementing the greedy selection logic:
                # 1. Find the smallest index i such that balls[i] is unused.
                # 2. If found, this is the start point.
                # 3. Calculate the next expected point (x + p, y + q).
                # 4. Check if the next expected point exists and is unused. Repeat until failure.
                
                # Since the provided structure doesn't allow for easy tracking of usage across multiple passes,
                # we must assume the input list 'balls' is structured such that the greedy choice is always the next available point in the list order.
                
                # Let's stick to the original structure's implied logic:
                # Start at the first unused point (index i).
                # Current point = balls[i].
                # Next expected point = (balls[i][0] + p, balls[i][1] + q).
                
                # We need a way to mark points as used. Let's use a boolean array 'used'.
                pass # Placeholder for complex logic adjustment if needed.
        
        # --- Reverting to the original structure's implied logic for simplicity ---
        # The original code snippet implies that the sequence is built by checking the next expected point
        # against the available points in the list.
        
        # We need to find the first unused point (start_index)
        start_index = -1
        for i in range(len(balls)):
            if not used[i]:
                start_index = i
                break
        
        if start_index == -1:
            return 0 # No more points left
        
        current_index = start_index
        count = 0
        
        while current_index != -1:
            count += 1
            used[current_index] = True
            
            # Calculate the next expected point
            next_x = balls[
