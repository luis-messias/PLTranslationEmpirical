import sys

def is_solution(columns_count, x):
    all_x = [True] * columns_count
    for i in range(12):
        if x[i] != 'X':
            all_x[i % columns_count] = False
    return any(all_x)

def main():
    t = int(input())
    for _ in range(t):
        s = input()
        solutions = []
        possible_solutions = 0
        if is_solution(12, s):
            solutions.append("1x12")
            possible_solutions += 1
        if is_solution(6, s):
            solutions.append("2x6")
            possible_solutions += 1
        if is_solution(4, s):
            solutions.append("3x4")
            possible_solutions += 1
        if is_solution(3, s):
            solutions.append("4x3")
            possible_solutions += 1
        if is_solution(2, s):
            solutions.append("6x2")
            possible_solutions += 1
        if is_solution(1, s):
            solutions.append("12x1")
            possible_solutions += 1
        print(possible_solutions)
        print(' '.join(solutions))

if __name__ == "__main__":
    main()