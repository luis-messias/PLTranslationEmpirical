import sys

class Calculator:
    def __init__(self, n, k, as_list):
        self.k = k
        self.answer = 0
        self.is_calculate = False
        self.lists = [[] for _ in range(n)]

        # Graph construction based on Java logic
        for i in range(n):
            j = as_list[i]
            
            # Java logic: if ( 0 < i ) { this.lists.get ( j ).add ( i ) ; } 
            if i > 0:
                # Add i to the list of predecessors of j
                self.lists[j].append(i)
            # Java logic: else if ( 0 < j ) { this.answer ++ ; }
            elif j > 0:
                self.answer += 1

    def calculate(self):
        if not self.is_calculate:
            self.dfs(0, 0)
            self.is_calculate = True
        return self.answer

    def dfs(self, a, pre):
        h = 0
        
        # Iterate over predecessors i of a
        for i in self.lists[a]:
            h = max(h, self.dfs(i, a))
        
        # Check condition for incrementing answer
        # Java: if ( 0 < pre && h == this.k - 1 )
        if pre > 0 and h == self.k - 1:
            h = 0
            self.answer += 1
        else:
            h += 1
        
        return h

def solve():
    # Read all input integers
    data = sys.stdin.read().split()
    if not data:
        return

    # Assuming input format: N K a0 a1 ... a(N-1)
    try:
        n = int(data[0])
        k = int(data[1])
        as_list = [int(x) for x in data[2:2+n]]
    except IndexError:
        # Handle case where input might be incomplete
        return

    calculator = Calculator(n, k, as_list)
    result = calculator.calculate()
    print(result)

if __name__ == "__main__":
    solve()