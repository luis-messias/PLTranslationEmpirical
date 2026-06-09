import sys

s = sys.stdin.read().strip()

if s == "Sunny":
    print("Cloudy")
elif s == "Cloudy":
    print("Rainy")
else:
    print("Sunny")