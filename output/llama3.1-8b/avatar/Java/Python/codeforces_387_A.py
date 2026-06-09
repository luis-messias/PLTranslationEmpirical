from datetime import datetime, timedelta
import sys

def main():
    s = input().split(":")
    t = input().split(":")

    x = datetime.strptime(f"{s[0]}:{s[1]}", "%H:%M").time()
    y = datetime.strptime(f"{t[0]}:{t[1]}", "%H:%M").time()

    print((x - timedelta(hours=y.hour, minutes=y.minute)))

if __name__ == "__main__":
    main()