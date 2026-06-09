import sys

def run():
    input_data = sys.stdin.read().split()
    for i in range(0, len(input_data), 3):
        if i + 2 < len(input_data):
            my1 = int(input_data[i])
            my2 = int(input_data[i+1])
            enemy1 = int(input_data[i+2])
            
            used = [False] * 11
            used[my1] = True
            used[my2] = True
            used[enemy1] = True
            
            all_count = 0
            safe_count = 0
            for j in range(1, 11):
                if not used[j]:
                    all_count += 1
                    if my1 + my2 + j <= 20:
                        safe_count += 1
            
            if safe_count * 2 >= all_count:
                print("YES")
            else:
                print("NO")

if __name__ == "__main__":
    run()
