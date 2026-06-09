import sys

class atcoder_ABC122_D:
    TOKENS = ["A", "C", "G", "T"]
    MOD = 1000000007

    def __init__(self):
        # Read N from standard input
        try:
            # Read all input and strip whitespace
            input_data = sys.stdin.read().strip()
            if input_data:
                self.N = int(input_data)
            else:
                self.N = 0
        except Exception:
            self.N = 0
        
        # Initialize memoization table: list of dictionaries
        # self.memo[current][last3] = result
        self.memo = [{} for _ in range(self.N + 1)]

    def calc(self):
        # Start DFS from current=0, last3="TTT"
        return self.dfs(0, "TTT")

    def is_ok(self, last4: str) -> bool:
        # Constraint 1: Check if last4 contains "AGC"
        if "AGC" in last4:
            return False
        
        # Constraint 2: Check swaps
        # We must check all 3 adjacent swaps (i=0, 1, 2)
        
        for i in range(3):
            # Create the swapped string s by swapping characters at i and i+1
            
            # Convert to list for mutable swapping
            vals = list(last4)
            
            # Swap logic: vals[i] <-> vals[i+1]
            vals[i], vals[i+1] = vals[i+1], vals[i]
            
            s = "".join(vals)
            
            if "AGC" in s:
                return False
                
        return True

    def dfs(self, current: int, last3: str) -> int:
        if last3 in self.memo[current]:
            return self.memo[current][last3]

        if current == self.N:
            return 1

        result = 0
        
        for c in self.TOKENS:
            # Check if the resulting 4-character string is valid
            if self.is_ok(last3 + c):
                # Calculate the next last3 string: drop the first char, append c
                next_last3 = last3[1:] + c
                
                # Recursive call and accumulation
                res = self.dfs(current + 1, next_last3)
                result = (result + res) % self.MOD
        
        self.memo[current][last3] = result
        return result

def main():
    ins = atcoder_ABC122_D()
    print(ins.calc())

if __name__ == "__main__":
    main()
