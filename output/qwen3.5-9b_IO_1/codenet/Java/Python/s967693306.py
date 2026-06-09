import sys
from collections import defaultdict

class Main:
    INF = float('inf')
    MOD = 1_000_000_007
    SIZE = 1_000_000
    
    def solve(self):
        n = int(input())
        m = int(input())
        map_constraints = {}
        
        for _ in range(m):
            s = int(input())
            c = int(input())
            if s in map_constraints and map_constraints[s] != c:
                print(-1)
                return
            map_constraints[s] = c
        
        for i in range(1000):
            s = str(i)
            if len(s) < n:
                continue
            
            flag = True
            for j in range(n):
                if j < len(s):
                    digit = int(s[j])
                    pos = j + 1
                    if pos in map_constraints:
                        if map_constraints[pos] != digit:
                            flag = False
                            break
                    else:
                        if digit != 0:
                            flag = False
                            break
                else:
                    flag = False
                    break
            
            if flag and len(s) == n:
                print(s)
                return
        
        print(-1)

if __name__ == "__main__":
    main = Main()
    main.solve()
