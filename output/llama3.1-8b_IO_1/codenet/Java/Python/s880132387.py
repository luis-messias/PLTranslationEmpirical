import random
import string

class Main:
    def __init__(self):
        self.sc = input()
        self.rand = random.Random()

    def run(self):
        while True:
            try:
                W, H = map(int, self.sc.split())
                if W == 0 and H == 0: return
                map_ = [list(input()) for _ in range(H)]

                dp = [[0] * W for _ in range(H)]
                max_val = 0

                for h in range(H):
                    for w in range(W):
                        if w > 0:
                            dp[h][w-1] = int(map_[h][w-1])
                        if h > 0:
                            dp[h-1][w] = int(map_[h-1][w])

                        if map_[h][w].isdigit():
                            max_val = max(dp[h-1][w], dp[h][w-1]) if (h > 0 and w > 0) else 0
                            dp[h][w] = int(max_val * 10 + int(map_[h][w]))
                        else:
                            dp[h][w] = 0

                max_val = max(dp[i][j] for i in range(H) for j in range(W))
                print(max_val)
            except ValueError:
                break

if __name__ == "__main__":
    Main().run()
