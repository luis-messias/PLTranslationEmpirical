import sys

s = input()
if len(s) < 4:
    print("Input too short")
else:
    s1, *rest_of_s = s[:2]
    if rest_of_s and (len(rest_of_s[0]) == 1):
        a = int(s1)
        
    else: 
        for i in range(3):  
            next_char = len(str(i+1)) + 1
            if not str(i).isdigit() or s[i] != chr(int(next_char)):
                print("Bad")
                sys.exit()
                
print("Good")