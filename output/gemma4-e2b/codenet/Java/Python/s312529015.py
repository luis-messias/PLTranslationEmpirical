import sys

try:
    # Read A
    A = int(sys.stdin.readline())
    # Read B
    B = int(sys.stdin.readline())
except:
    # Handle potential EOF or empty input if necessary, though usually not required for direct translation
    exit()

if (A % 3 == 0) or (B % 3 == 0) or ((A + B) % 3 == 0):
    print("Possible")
else:
    print("Impossible")