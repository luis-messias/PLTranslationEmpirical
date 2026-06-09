import re

def main():
    S = input()
    
    for i in range(len(S)):
        for j in range(len(S)):
            begin = S[:i]
            end = S[j:]
            answer = begin + end
            
            if "keyence" in answer:
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