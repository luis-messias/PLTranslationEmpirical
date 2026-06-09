import sys

def permutation(list_ref, target, ans):
    """
    Recursively generates all permutations of the characters in 'target'
    and appends them to list_ref.
    """
    if len(target) <= 1:
        list_ref.append(ans + target)
    else:
        for i in range(len(target)):
            # Remaining target string after removing char at index i
            new_target = target[:i] + target[i+1:]
            # Recursive call
            permutation(list_ref, new_target, ans + target[i])
    return list_ref

def solve():
    # Read all input tokens
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return

    # N is the first element
    try:
        N = int(input