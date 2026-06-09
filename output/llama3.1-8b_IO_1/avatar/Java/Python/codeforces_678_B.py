import datetime

def is_leap_year(year):
    return year % 4 == 0 and (year % 100 != 0 or year % 400 == 0)

def main():
    y = int(input())
    leap = is_leap_year(y)
    sum_days = 0
    i = y + 1
    while True:
        if is_leap_year(i):
            sum_days += 366
        else:
            sum_days += 365
        if sum_days % 7 == 0:
            if (is_leap_year(i) and leap) or (not is_leap_year(i) and not leap):
                print(i)
                return
        i += 1

main()
