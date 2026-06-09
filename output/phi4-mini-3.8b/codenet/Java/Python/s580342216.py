import sys

def run_case():
  N = int(input().split()[0])
  K = input().strip()
  len_ = 1
  while (N > 0):
      N //= K
      if not (N % 1 and str_to_int_array(K) - [int(x) for x in map(int, K.split())] == []): 
        break
    print(len_)
  
def get_lcs(X, Y):

  m = len(X)
  n = len(Y)

  dp = [[0]*(n+1)]

  for i in range(1, (m + 1)):
      for j in range(1, (n + 1)):

        if X[i - 1] == Y[j - 1]:
          dp [i][j] = max(dp [i - 1][j], dp [i][j - 1]) + 1
        else:
          dp [i][j] = max (dp [i - 1][j], dp [i][j - 1])

  index, i, j = m, n

  while not ((not X and Y) or str_to_int_array(X if len_ > 0 else Y)):
    if X and Y:
      if X[i - 1] == Y[j - 1]:
        LCS [i][j], (index), index -= 1
        i, j = i - 1, j - 1

  return str_to_int_array(X) + "LCS of "+X+" and "+Y+": "+str(LCS)

def get_lcs():
  X, Y = input().split()
  
  if not (get_lcs):
    print(get_lcs)