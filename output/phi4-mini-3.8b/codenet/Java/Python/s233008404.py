import math

class Main:
    def __init__(self):
        self.color_mtr = []
        self.h = 0
        self.w = 0
        self.k = 0
    
    def solve(self, input_data=None):
        if input_data is None: 
            import sys
            from io import StringIO

            f = StringIO(sys.stdin.read())
            input_lines = iter(f.readline().splitlines()).__next__
        
        h, w, k = map(int, next(input_lines).strip().split())

        self.h = h
        self.w = w
        self.k = k
        
        for _ in range(h):
            row = list(next(input_lines))
            self.color_mtr.append(row)
            
        h_pattern = 2 ** h
        w_pattern = 2 ** w

        ans = 0
        
        for i in range(h_pattern):
            for j in range(w_pattern):
                if self.judge(i, j):
                    ans += 1
                    
        print(ans)

    def judge(self, h_pattern, w_pattern):
        h_bit_arr = [int((h_pattern >> x) & 1) for x in range(self.h)]
        w_bit_arr = [int((w_pattern >> y) & 1) for y in range(self.w)]

        black_count = sum(1 for i in range(self.h)
                         for j in range(self.w)
                         if (h_bit_arr[i] == 0 and w_bit_arr[j] == 0
                             and self.color_mtr[i][j] == "#")
        
        return black_count == self.k

if __name__ == "__main__":
    main_obj = Main()
    input_data = None # Replace with actual data if needed for testing, otherwise use sys.stdin.read() to get standard input.
    main_obj.solve(input_data)