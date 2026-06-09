import array

def run():
    while True:
        my1 = int(input())
        my2 = int(input())
        enemy1 = int(input())
        used = [False] * 11
        used[my1 - 1], used[my2 - 1], used[enemy1 - 1] = (True, True, True)
        all, safe = 0, 0
        for i in range(1, 11):
            if not used[i]:
                all += 1
                if my1 + my2 + i <= 20:
                    safe += 1
        print("YES" if (safe * 2) >= all else "NO")

if __name__ == "__main__":
    run()