import sys

try:
    A = int(sys.stdin.readline())
    B = int(sys.stdin.readline())
    C = int(sys.stdin.readline())
except:
    # Handle case where input might be missing or invalid, though usually not strictly necessary for this type of translation
    exit()

if A == B and B == C and C == A:
    print("Yes")
else:
    print("No")