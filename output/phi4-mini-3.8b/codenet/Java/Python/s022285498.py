import sys

class Task:
    
    def solve(self, test_number, in_stream):
        n = int(in_stream.readline().strip())
        count_arr = [0] * (n + 1)
        
        for x in range(1, 101):
            for y in range(1, 101):
                for z in range(1, 101):
                    value = x**2 + y**2 + z**2 + x*y + x*z + y*z
                    if value > n:
                        break
                    count_arr[value] += 1
        
        result = [count_arr[i] for i in range(n+1)]
        
        sys.stdout.write('\n'.join(map(str, result)))
        

def main():
    task = Task()
    
    input_stream = sys.stdin.read().splitlines()
    
    test_number = int(input_stream[0])
    if test_number == 1:
        task.solve(1, iter(input_stream[1:]))
        
if __name__ == "__main__":
    main()