import sys

def min(arr, n):
  if n == 1:
      return 0
  if n == 2: 
      return abs(arr[1] - arr[0])
  
  op1 = (abs(arr[n-1] - arr[n-2]) + min(arr, n - 1)
  op2 = (abs(arr[n-1] - arr[n-3]) + min(arr, n - 2))
  return min(op1, op2)

def dpc(arr, i, j):
  if i == len(j) and row:
      return 0
  k=0
  if i==1: 
    j = 0;  
    k = 2;
  elif i==0: 
    j = 1;  
    k = 2;
  else :   
    j, k = 0, 1

  return arr[row][i] + max(dpc(arr, j, n, row+1), dpc (arr,k,n,row+1))

def dpx (arr):
  for i in range(3): 
      if i == 1:  
        a[0], b = 0; c=2
    elif i==0:
        a, b = 1, 2;
    else :   
       a, b = 0, 1

  dp[i][j] = max(dp [i-1][k] ,dp [i - 1][a]) + arr[ (n) 

if __name__ == "__main__":
  n = int(sys.stdin.readline)
  
  for i in range(n):
    a = list(map(int, sys.stdin.readline().split())
    
  ans=0
  if dpx(a,n): 
      print(ans)

  dp = [a]
  for j in range (3) : 

  return max(dp[n -1][j] ,dp [n-1][k])