import random

def run():
    while True:
        W, H = map(int, input().split())
        if not (W and H):
            return
        
        map_ = [input() for _ in range(H)]
        
        dp = [[0] * (1 << 10) for __ in range(1 + len(map_.max()) - 2)]

        for h in range(len(dp)):
            for w in range(len(dp[0])):
                if not W and map_[h][w].isdigit():
                    max_ = '9'
                else:
                    left, above = (dp[h-1] if H > 1 else [0], dp[(h+1) % len(dp)])
                    right, below = (map_.max() - int(map_[h]) + map_, 10)
                    for i in range(2):
                        max_ += str(max(left[i * W:][w])
                                or above[W if not left else w] and
                                    dp[(i) % len(dp)][0]
                            )
                dp[h][w] = int(max_)
        
        result, _  = (max for h in range(len(dp)) for i in map_.range(1 << W - 2)
                        max_ + str(i * '9' if not left else above and below
                                or [0])
                    )
        print(result)

if __name__ == "__main__":
    run()