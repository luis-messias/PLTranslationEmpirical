def check_leap(y):
    return y % 400 == 0 or (y % 4 == 0 and y % 100 != 0)

def solve():
    try:
        y = int(input())
    except EOFError:
        return

    leap = check_leap(y)
    sum_days = 0
    
    i = y + 1
    while True:
        if check_leap(i):
            days = 366
        else:
            days = 365
        
        sum_days += days
        
        if sum_days % 7 == 0:
            current_leap = check_leap(i)
            
            # Check if leap status matches the starting year's leap status
            if (current_leap and leap) or (not current_leap and not leap):
                print(i)
                return
        
        i += 1

if __name__ == "__main__":
    solve()