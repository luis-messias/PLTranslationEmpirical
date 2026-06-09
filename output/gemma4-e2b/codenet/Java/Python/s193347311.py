import sys

def solve():
    # Read all input tokens
    tokens = sys.stdin.read().split()
    
    if not tokens:
        return

    try:
        intLoop = int(tokens[0])
    except ValueError:
        return

    if len(tokens) < 1 + 2 * intLoop:
        return

    intTaro = 0
    intHana = 0

    # Iterate through the pairs starting from the second token (index 1)
    for i in range(intLoop):
        # Tokens are structured as: intLoop, T1, H1, T2, H2, ...
        # strTaro is at index 1 + 2*i
        # strHana is at index 2 + 2*i
        strTaro = tokens[1 + 2 * i]
        strHana = tokens[2 + 2 * i]

        # Equivalent to strTaro.compareTo(strHana)
        if strTaro < strHana:
            # intJudge < 0
            intHana += 3
        elif strTaro == strHana:
            # intJudge == 0
            intTaro += 1
            intHana += 1
        else: # strTaro > strHana
            # intJudge > 0
            intT