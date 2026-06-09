import sys

# Read all input tokens
data = sys.stdin.read().split()

if len(data) < 2:
    # Handle case where input is insufficient
    exit()

N = int(data[0])
S = data[1]

result = []
base = ord('A')

for char in S:
    if 'A' <= char <= 'Z':
        # Apply the Caesar cipher shift logic