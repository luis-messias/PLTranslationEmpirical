import sys
from collections import defaultdict

def is_possible(k: int, a: list[int]) -> bool:
    """
    Checks if it is possible to arrange the elements such that the maximum difference 
    between adjacent elements is at most k.
    This function mirrors the logic from the Java implementation using a TreeMap simulation.
    """
    # s acts as the TreeMap, storing {value: count}
    s = defaultdict(int)
    current = 0
    
    for ai in a:
        if ai <= current:
            if k == 1:
                return False
            
            # Simulate s.pollLastEntry() while s.lastKey() >= ai
            # In Java TreeMap, lastKey() gives the largest key.
            
            # We need to find all keys >= ai and remove them.
            # Since we are using defaultdict, we must ensure we only operate on existing keys.
            
            # Get keys currently in s
            keys = list(s.keys())
            
            # Find keys to remove (those >= ai)
            to_remove = []
            for key in keys:
                if key >= ai:
                    to_remove.append(key)
            
            # Remove them
            for key in to_remove:
                del s[key]
            
            # The Java logic implies that we are removing elements that are "too large" 
            # relative to the current element ai, effectively merging them into the current group.
            # The Java code uses s.pollLastEntry(), which suggests removing the largest elements first.
            
            # Since we are simulating a TreeMap where keys are ordered, we need to handle the removal carefully.
            # If we rely on the fact that we only care about the maximum key, we can simplify.
            
            # Replicating the specific TreeMap behavior: remove all entries whose keys are >= ai.
            # Since we are simulating a structure where we remove the largest elements, 
            # we iterate over keys in descending order.
            
            keys_to_remove = sorted([key for key in s.keys() if key >= ai], reverse=True)
            for key in keys_to_remove:
                del s[key]


            # The Java code then proceeds to calculate the new count for ai - 1, 
            # which suggests that the elements removed are effectively merged into the current group.
            
            # The Java logic:
            # int p = ai - 1;
            # while (true) {
            #     if (p < 0) return false;
            #     int sp = s.getOrDefault(p, 0) + 1;
            #     s.put(p, sp);
            #     if (sp == k) { s.remove(p); p--; } else { break; }
            # }
            
            # This part is highly specific and seems to manage the resulting
