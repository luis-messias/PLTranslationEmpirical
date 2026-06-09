import sys

def main():
    input = iter(sys.stdin.read).__next__
    
    h, w = map(int, [input() for _ in range(2)])
    ans = ["#" + next(input) + "#" for _ in range(h)]
    
    print("\0" * (w + 2)).replace(" ", "#")
    for s in ans:
        sys.stdout.write(s + "\n")

if __name__ == "__main__":
    main()