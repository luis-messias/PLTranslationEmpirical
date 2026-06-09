import sys

# Set recursion limit higher for safety, although not strictly necessary for this problem structure
# sys.setrecursionlimit(2000)

class Main:
    def __init__(self):
        self.color_mtr = []
        self.h = 0
        self.w = 0
        self.k = 0

    def solve(self):
        # Fast input reading simulation
        input_data = sys.stdin.read().split()
        if not input_data:
            return

        data_index = 0

        # Read H, W, K
        self.h = int(input_data[data_index])
        data_index += 1
        self.w = int(input_data[data_index])
        data_index += 1
        self.k = int(input_data[data_index])
        data_index += 1

        # Read colorMtr
        self.color_mtr = []
        for i in range(self.h):
            # Each row is read as a single string token in the input stream
            row_str = input_data[data_index]
            self.color_mtr.append(list(row_str))
            data_index += 1

        # Calculate pattern sizes (2^h, 2^w)
        h_pattern = self.pow(2, self.h)
        w_pattern = self.pow(2, self.w)

        ans = 0

        # Iterate through all combinations of row/column selections (bitmasks)
        for i in range(h_pattern):
            for j in range(w_pattern):
                if self.judge(i, j):
                    ans += 1

        print(ans)

    def judge(self, h_pattern, w_pattern):
        
        h_bit_arr = [0] * self.h
        w_bit_arr = [0] * self.w
        
        # Determine selected rows (1 if bit is 1)
        for i in range(self.h):
            if ((h_pattern >> i) & 1) == 1:
                h_bit_arr[i] = 1
        
        # Determine selected columns (1 if bit is 1)
        for i in range(self.w):
            if ((w_pattern >> i) & 1) == 1:
                w_bit_arr[i] = 1
        
        black = 0
        
        # Count '#' in cells (i, j) where row i AND column j are NOT selected
        for i in range(self.h):
            for j in range(self.w):
                # Check if row i OR column j is selected
                if h_bit_arr[i] == 1 or w_bit_arr[j] == 1:
                    continue
                
                # Cell (i, j) is in an unselected row and unselected column
                if self.color_mtr[i][j] == "#":
                    black += 1
        
        return black == self.k

    def pow(self, base, n):
        # Calculates base^n
        return base ** n

def main():
    main_obj = Main()
    main_obj.solve()

if __name__ == "__main__":
    main()