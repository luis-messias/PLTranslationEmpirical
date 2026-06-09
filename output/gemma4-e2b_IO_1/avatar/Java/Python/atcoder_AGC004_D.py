import sys

class Calculator:
    def __init__(self, n: int, k: int, as_list: list[int]):
        self.k = k
        # Initialize adjacency list for n nodes (0 to n-1)
        self.lists = [[] for _ in range(n)]
        self.answer = 0

        # Build the graph structure and calculate initial answer based on the Java logic:
        # for ( int i = 0 ; i < n ; i ++ ) { int j = as.get(i) ; if ( 0 < i ) { this.lists.get(j).add( i ) ; } else if ( 0 < j ) { this.answer ++ ; } }
        
        for i in range(n):
            j = as_list[i]
            if i > 0:
                # If i > 0, add i to lists[j]
                if 0 <= j < n:
                    self.lists[j].append(i)
            elif j > 0:
                # If i == 0, check if j > 0, increment answer
                self.answer += 1

    def calculate(self) -> int:
        if not self.isCalculate:
            self.dfs(0, 0)
            self.isCalculate = True
        return self.answer

    def dfs(self, a: int, pre: int) -> int:
        h = 0
        # Iterate over neighbors in lists[a]
        for i in self.lists[a]:
            h = max(h, self.dfs(i, a))
        
        # Check the condition for incrementing the answer
        if 0 < pre and h == self.k - 1:
            h = 0
            self.answer += 1
        else:
            h += 1
            
        return h

def main():
    # Read all input from stdin
    data = sys.stdin.read().split()
    
    if not data:
        return

    # The input sequence is n, k, followed by n elements of as
    n = int(data[0])
    k = int(data[1])
    
    as_list = []
    # The remaining n elements are the list 'as'
    for i in range(2, 2 + n):
        as_list.append(int(data[i]))

    if n == 0:
        print(0)
        return

    calculator = Calculator(n, k, as_list)
    result = calculator.calculate()
    print(result)

if __name__ == "__main__":
    main()
