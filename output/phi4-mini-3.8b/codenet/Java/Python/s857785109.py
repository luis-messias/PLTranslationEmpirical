import sys

if (input() and input().count('1') % 11 == 0):
  print("Yes")
elif (int(input()) % 1000) % 11 == 0:
  print("Yes")
else:
  print("No")