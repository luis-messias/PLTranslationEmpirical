import sys

class InputIterator:
    inputLine = []
    
    def __init__(self):
        for line in iter(sys.stdin.readline, ''): 
            self.inputLine.append(line)
            
    def hasNext(self):
        return len(self.inputLine) > 0
    
    def next(self):
        if not self.hasNext():
            raise IndexError("There is no more input")
        else:
            result = self.inputLine.pop(0)

class Main:
    
    CONVSTR = {8: " ", 9: "\n", 0: ""}
    ii = InputIterator()
    out = sys.stdout
    flush = lambda x : None # No need for a function in Python, as it is not used here.
    
    def myout(self, t):
        self.out.write(t + '\n')
        
    def solve():
        N = nextInt()
        list_ = [0] * (N)
        max_val = 0
        output = 0
        
        for i in range(N):
            if max_val <= get(i) and not hasNext:
                raise IndexError("There is no more input")
            else: 
                value = nextInt()
                list_[i] = value
                if value > max_val:
                    max_val, output = value, 1 + (output * i)
        
        myout(output)

if __name__ == "__main__":
    solve()