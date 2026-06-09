from collections import deque

def main():
    list = deque()
    
    while True:
        try:
            a = int(input())
            if a == 0:
                print(list.pop() if list else "None")
            else:
                list.append(a)
        except EOFError:
            break

if __name__ == "__main__":
    main()