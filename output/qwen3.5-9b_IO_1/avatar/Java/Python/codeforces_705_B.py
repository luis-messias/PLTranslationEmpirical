import sys

class FastReader:
    def __init__(self):
        self.br = sys.stdin
        self.st = None
    
    def next(self):
        while self.st is None or not self.st:
            try:
                line = self.br.readline()
                if not line:
                    return None
                self.st = line.split()
            except:
                return None
        return self.st.pop(0)
    
    def nextInt(self):
        return int(self.next())

def solve():
    reader = FastReader()
    t = reader.nextInt()
    arr = [reader.nextInt() for _ in range(t)]
    
    prevWinner = 0
    for i in range(len(arr)):
        if arr[i] == 1:
            if prevWinner == 0:
                prevWinner = 2
        
        if prevWinner == 2 or prevWinner == 0:
            if (arr[i] - 1) % 2 == 0:
                print(2)
                prevWinner = 2
            else:
                print(1)
                prevWinner = 1
        else:
            if (arr[i] - 1) % 2 == 0:
                print(1)
                prevWinner = 1
            else:
                print(2)
                prevWinner = 2

if __name__ == "__main__":
    solve()
