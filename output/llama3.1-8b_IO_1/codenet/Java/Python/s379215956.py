import sys

def main():
    s = input()
    a = 0
    
    for i in range(len(s)-1):
        if s[i] == s[i+1]:
            a += 1
            break
    
    if a > 0:
      print("Bad")
    else:
      print("Good")

main()
