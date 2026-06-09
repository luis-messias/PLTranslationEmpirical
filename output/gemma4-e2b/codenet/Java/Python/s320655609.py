import sys

def main():
    # Read N
    try:
        # Read N from the first line
        n_line = sys.stdin.readline()
        if not n_line:
            return
        N = int(n_line.strip())
    except ValueError:
        return
    except EOFError:
        return

    constraints = []
    # Read 5 constraints
    for _ in range(5):
        try:
            line = sys.stdin.readline()
            if not line:
                break
            constraints.append(int(line.strip()))
        except ValueError:
            # Stop reading if input is invalid
            break

    if not constraints:
        return

    # Calculate the minimum constraint
    min_