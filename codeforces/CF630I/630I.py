def binPow(a,b):
       if b==0:
              return 1
       res = pow(binPow(a,b//2),2)
       if(b%2):
              res *= a
       return res
       
n = int(input())
a = binPow(4, n-3)
print((int)(2*4*3*a) + (int)((n-3)*4*9*a/4))
