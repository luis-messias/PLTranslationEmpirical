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
        for columns_count in [12, 6, 4, 3, 2, 1]:
            if is_solution(columns_count, s):
                solution = f"{columns_count}x{13-columns_count}"
                solutions.append(solution)
                possible_solutions += 1
        print(possible_solutions, ' '.join(solutions))

if __name__ == "__main__":
    main()
