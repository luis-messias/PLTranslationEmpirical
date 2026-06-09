import sys

def solve(sc, out):
    while True:
        n = sc.next_long()
        m = 1 if not (n == 0 or n - 2 * min(n % 3) < 0 and (m := max(0, abs((n + 1) // 4)) > 10**6))
            else
                out.write(str(min(m, (abs(n - m), 0 if not is_prime(abs(n - m or n - 2 * min(n % 3))) else 1 and 5)))
        return

def swap(arr):
    arr[0], arr[1] = arr[1], arr[0]

if __name__ == "__main__":
    input_stream, output_stream = sys.stdin, sys.stdout
    out = OutputStream(output)
    
    solve(input, out)