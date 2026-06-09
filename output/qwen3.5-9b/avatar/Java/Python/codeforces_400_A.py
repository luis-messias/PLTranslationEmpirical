import sys

def isSolution(columnsCount, x):
    allXs = [True] * columnsCount
    for i in range(12):
        if x[i] != 'X':
            allXs[i % columnsCount] = False
    for i in range(columnsCount):
        if allXs[i]:
            return True
    return False

def main():
    t = int(input())
    for _ in range(t):
        s = input()
        possibleSolutions = 0
        solutions = []
        if isSolution(12, s):
            solutions.append("1x12")
            possibleSolutions += 1
        if isSolution(6, s):
            solutions.append("2x6")
            possibleSolutions += 1
        if isSolution(4, s):
            solutions.append("3x4")
            possibleSolutions += 1
        if isSolution(3, s):
            solutions.append("4x3")
            possibleSolutions += 1
        if isSolution(2, s):
            solutions.append("6x2")
            possibleSolutions += 1
        if isSolution(1, s):
            solutions.append("12x1")
            possibleSolutions += 1
        print(possibleSolutions)
        print(" ".join(solutions))

if __name__ == "__main__":
    main()