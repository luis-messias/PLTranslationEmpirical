import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    if not data:
        return

    # N is the first token
    n = int(data[0])
    
    # Initialize arrays (lists) of size 367
    FfriendPerDay = [0] * 367
    MfriendPerDay = [0] * 367
    answer = 0
    
    data_index = 1
    
    for _ in range(n):
        # Read character c
        c = data[data_index]
        data_index += 1
        
        # Read a and b
        a = int(data[data_index])
        b = int(data[data_index + 1])
        data_index += 2
        
        # Process the range [a, b]
        for j in range(a, b + 1):
            if c == 'M':
                MfriendPerDay[j] += 1
            else:
                FfriendPerDay[j] += 1
        
        # Update answer based on the counts at index j (which is b in this context)
        # Note: The original Java code uses 'j' here, which refers to the loop variable from the previous scope.
        # In the Java code, j would be the value of the last iteration (b).
        
        # We must ensure j is within bounds, although the problem constraints usually guarantee this.
        if a <= j <= b:
            if MfriendPerDay[j] < FfriendPerDay[j]:
                if MfriendPerDay[j] > answer:
                    answer = MfriendPerDay[j]
            else:
                if FfriendPerDay[j] > answer:
                    answer = FfriendPerDay[j]

    # The final result is answer * 2
    print(answer * 2)

solve()