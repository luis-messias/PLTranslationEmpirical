import sys

class Atcoder_AGC046_B:
    MOD = 998244353

    def solve(self):
        # Read all four integers A, B, C, D from standard input
        try:
            data = sys.stdin.read().split()
            if not data:
                return
            A = int(data[0])
            B = int(data[1])
            C = int(data[2])
            D = int(data[3])
        except Exception:
            # Handle case where input might be malformed or empty
            return

        # Initialize DP table. Size needs to accommodate indices up to 3000.
        # We use (C+1) x (D+1) size for safety, but since the problem constraints
        # suggest indices up to 3000, a fixed size or dynamic sizing based on C, D is fine.
        # Since the Java code used 3001, we stick to that maximum size for the array structure.
        MAX_SIZE = 3001
        dp = [[0] * MAX_SIZE for _ in range(MAX_SIZE)]

        # Base case
        dp[A][B] = 1

        for c in range(A, C + 1):
            for d in range(B, D + 1):
                if c == A and d == B:
                    continue

                ans = 0

                # Contribution from dp[c-1][d] * d
                if c > A:
                    part = dp[c - 1][d]
                    ans = (part * d) % self.MOD

                # Contribution from dp[c][d-1] * c
                if d > B:
                    part = dp[c][d - 1]
                    contribution = (part * c) % self.MOD
                    ans = (ans + contribution) % self.MOD

                # Overlap subtraction: dp[c-1][d-1] * (c-1) * (d-1)
                if c > A and d > B:
                    part = dp[c - 1][d - 1]
                    subtraction = (part * (c - 1) * (d - 1)) % self.MOD
                    
                    # Modular subtraction: (a - b) % m = (a - b + m) % m
                    ans = (ans - subtraction + self.MOD) % self.MOD

                dp[c][d] = ans

        print(dp[C][D])

if __name__ == "__main__":
    solver = Atcoder_AGC046_B()
    solver.solve()