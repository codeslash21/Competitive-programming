class Solution:
    def countGoodNumbers(self, n: int)->int:
        e=n%2
        res = pow(20,n//2,10**9+7)
        if e:
            res*=5
        return res%1000000007
