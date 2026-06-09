import sys

def solve():
    # Read all input tokens
    data = sys.stdin.read().split()
    if not data:
        return

    # N is the first element
    n = int(data[0])
    
    # Initialize arrays for friend counts (size 367 for days 0 to 366)
    FfriendPerDay = [0] * 367
    MfriendPerDay = [0] * 367
    answer = 0
    
    data_index = 1
    
    for i in range(n):
        # Read c, a, b for the current person/group
        c = data[data_index]
        a = int(data[data_index + 1])
        b = int(data[data_index + 2])
        data_index += 3
        
        # Update counts for the range [a, b]
        for j in range(a, b + 1):
            if c == 'M':
                MfriendPerDay[j] += 1
            else: # c == 'F'
                FfriendPerDay[j] += 1
            
            # Apply the specific update logic for 'answer'
            if MfriendPerDay[j] < FfriendPerDay[j]:
                if MfriendPerDay[j] > answer:
                    answer = MfriendPerDay[j]
            else: # MfriendPerDay[j] >= FfriendPerDay[j]
                if FfriendPerDay[j] > answer:
                    answer = FfriendPerDay[j]

    print(answer * 2)

solve()