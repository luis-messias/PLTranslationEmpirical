import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    
    if not data:
        return

    # The first two tokens are N and S
    try:
        n = int(data[0])
        s = int(data[1])
    except IndexError:
        # Handle case where input might be incomplete
        return

    # Initialize max based on the logic: max starts at 0 in Java, 
    # but we compare against s at the end.
    max_val = s
    
    # The remaining tokens are F and T pairs. They start from index 2.
    # We iterate n times, reading 2 tokens per iteration.
    
    data_index = 2
    for _ in range(n):
        if data_index + 1 < len(data):
            try:
                f = int(data[data_index])
                t = int(data[data_index + 1])
                
                current_sum = f + t
                if current_sum > max_val:
                    max_val = current_sum
                
                data_index += 2
            except ValueError:
                # Should not happen if input adheres to format
                break
        else:
            # Ran out of input unexpectedly
            break

    # The Java code calculates max(max_found, s) and prints it.
    # Since we initialized max_val = s, we just need to ensure max_val holds the maximum.
    # The Java code initializes max=0 and then prints Math.max(max, s).
    # Let's re-trace the Java logic:
    # int max = 0;
    # ... loop updates max = max(max, f+t)
    # o.println(Math.max(max, s));
    
    # Re-implementing strictly based on Java initialization:
    max_found = 0
    
    data_index = 2
    for _ in range(n):
        if data_index + 1 < len(data):
            f = int(data[data_index])
            t = int(data[data_index + 1])
            
            current_sum = f + t
            if max_found < current_sum:
                max_found = current_sum
            
            data_index += 2
        else:
            break

    print(max(max_found, s))

solve()