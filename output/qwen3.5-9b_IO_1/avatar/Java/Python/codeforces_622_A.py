import sys

def getValueAtIndex(index):
    return 1 + (index - 1) * index // 2

def solve():
    position = int(sys.stdin.read().strip())
    
    nrstSeqStartIndx = 1
    while getValueAtIndex(nrstSeqStartIndx * 2) < position:
        nrstSeqStartIndx *= 2
    
    while getValueAtIndex(nrstSeqStartIndx + 1) <= position:
        nrstSeqStartIndx += 1
    
    startIndex = getValueAtIndex(nrstSeqStartIndx)
    print(position - startIndex + 1)

solve()
