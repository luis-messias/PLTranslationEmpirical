from datetime import datetime, timedelta

def main():
    s = input().split(":")
    t = input().split(":")

    x = datetime.strptime(f"{s[0]}:{s[1]}", "%H:%M").time()
    y = datetime.strptime(f"{t[0]}:{t[1]}", "%H:%M").time()

    diff = timedelta(hours=x.hour - y.hour, minutes=x.minute - y.minute)
    if x.minute < y.minute:
        diff += timedelta(hours=1)
    print(diff)

if __name__ == "__main__":
    main()
