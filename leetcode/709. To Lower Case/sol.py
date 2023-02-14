# approach 1
class Solution:
    def toLowerCase(self, s: str) -> str:
        ss=''
        for i in s:
            if ord(i)>64 and ord(i)<91:
                ss+=chr(ord(i)+32)
            else:
                ss+=i

        return ss

      
      
# approach 2 (using ascii value)
class Solution:
    def toLowerCase(self, s: str) -> str: 
        is_upper = lambda x : 'A' <= x <= 'Z'
        to_lower = lambda x : chr(ord(x) | 32)
        
        return ''.join([to_lower(x) if is_upper(x) else x for x in s])
      
# approach 3 (using hash map)
class Solution:
    def toLowerCase(self, s: str) -> str:
        upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        lower = "abcdefghijklmnopqrstuvwxyz"
        h = dict(zip(upper, lower))
        
        return ''.join([h[x] if x in h else x for x in s])
      
      
# t.c. = O(n) for all approach
# s.c. = O(n) for all approach
