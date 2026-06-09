import sys

def main():
    S = input().strip()
    
    for i in range(len(S)):
        begin = S[:i]
        
        end = S[i:]
        
        answer = begin + end
        
        if answer == "keyence":
            print("YES")
            return
            
        elif begin == "keyence":
            print("YES")
            return
            
        elif end == "keyence":
            print("YES")
            return
    
    print("NO")

if __name__ == "__main__":
    main()