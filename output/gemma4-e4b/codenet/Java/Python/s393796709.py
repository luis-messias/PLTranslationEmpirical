import sys

class Main:
    MOD = 1000000007

    def f(self, n):
        """Calculates n! mod MOD"""
        res = 1
        for i in range(2, n + 1):
            res = (res * i) % self.MOD
        return res

    def solve(self):
        # Read all input from stdin
        input_data = sys.stdin.read().strip()
        if not input_data:
            return

        try:
            # Assuming input is a single line of space-separated integers
            xx = list(map(int, input_data.split()))
        except ValueError:
            return

        if len(xx) < 2:
            return

        x0 = xx[0]
        x1 = xx[1]
        
        min_val = min(x0, x1)
        max_val = max(x0, x1)
        
        res = 0
        
        if min_val == max_val:
            f_val = self.f(min_val)
            # res = (2 * f * f) % MOD
            res = (2 * f_val * f_val) % self.MOD
        elif min_val + 1 == max_val:
            f_val = self.f(min_val)
            # res = (f * ((f * max) % MOD)) % MOD
            # Calculate (f * max) % MOD first
            term2 = (f_val * max_val) % self.MOD
            # Then calculate f * term2 % MOD
            res = (f_val * term2) % self.MOD
        else:
            res = 0
            
        print(res)

if __name__ == "__main__":
    Main().solve()