import re

def main():
    s = input()
    a = 0
    
    if len(set(s[i:i+2]) for i in range(len(s)-1)) == 1:
        print("Bad")
    else:
      print("Good")

main()