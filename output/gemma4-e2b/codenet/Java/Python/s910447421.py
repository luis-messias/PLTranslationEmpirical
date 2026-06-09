import sys
import math

# Set recursion limit higher for potential deep recursive calls, although not strictly necessary here
# sys.setrecursionlimit(2000)

def min_val(a, b):
    return min(a, b)

def max_val(a, b):
    return max(a, b)

def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

def fast_exp(base, exp, mod):
    ans = 1
    base %= mod
    while exp > 0:
        if exp % 2 == 1:
            ans = (ans * base) % mod
        exp //= 2
        base = (base * base) % mod
    return ans

def mod_inv(num, mod):
    # Modular inverse using Fermat's Little Theorem (assuming mod is prime)
    return fast_exp(num, mod - 2, mod)

def pop(x):
    # Returns number of set bits (population count)
    cnt = 0
    while x > 0:
        if x % 2 == 1:
            cnt += 1
        x //= 2
    return cnt

class Main:
    def solve(self):
        # Read all input from stdin
        data = sys.stdin.read().split()
        if not data:
            return

        I = 0
        
        N = int(data[I])
        I += 1
        ans = N
        
        balls = []
        for i in range(N):
            x = int(data[I])
            y = int(data[I+1])
            balls.append([x, y])
            I += 2

        # First sort by x-coordinate
        balls.sort(key=lambda x: x[0])

        # First solve call
        self.solve_logic(balls, N, ans)

        # Swap coordinates and sort again
        for i in range(N):
            balls[i][0], balls[i][1] = balls[i][1], balls[i][0]
        
        # Second sort by x-coordinate
        balls.sort(key=lambda x: x[0])

        # Second solve call
        self.solve_logic(balls, N, ans)

        # Output the result
        print(ans)

    def check(self, balls, N, p, q):
        taken = [False] * N
        ret = 0
        
        while True:
            added = False
            start = -1
            x_target = -1
            y_target = -1
            
            # Find the first untaken ball to start the chain
            for i in range(N):
                if not taken[i]:
                    added = True
                    ret += 1
                    start = i
                    taken[i] = True
                    # Calculate the next target point based on the current point and differences (p, q)
                    x_target = balls[i][0] + p
                    y_target = balls[i][1] + q
                    break
            
            if not added:
                break
            
            # Try to find the next point matching the target (x_target, y_target)
            for i in range(start + 1, N):
                if balls[i][0] == x_target and balls[i][1] == y_target:
                    taken[i] = True
                    x_target += p
                    y_target += q
        
        return ret

    def solve_logic(self, balls, N, current_ans):
        # Iterate through all possible differences defined by the first point and subsequent points
        for add in range(1, N):
            # p and q are the differences between balls[add] and balls[0]
            p = balls[add][0] - balls[0][0]
            q = balls[add][1] - balls[0][1]
            
            # Check the maximum number of balls that can be connected with these differences
            result = self.check(balls, N, p, q)
            current_ans = min(current_ans, result)

# Execute the main logic
if __name__ == "__main__":
    Main().solve()