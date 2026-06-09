import sys

def sub(a, b):
    min_val = min(a, b)
    max_val = max(a, b)
    result = 0
    
    min_current = min_val
    max_current = max_val
    
    while min_current > 0:
        # result += max / min; (Integer division)
        result += max_current // min_current
        
        # max = max % min;
        max_current = max_current % min_current