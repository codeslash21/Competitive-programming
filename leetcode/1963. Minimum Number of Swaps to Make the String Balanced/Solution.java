// using stack trick
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int minSwaps(String s) {
        int n=s.length();
        int cnt=0;
        for(int i=0;i<n;i++)
            if(s.charAt(i)=='[')
                cnt++;
            else if(cnt>0)
                cnt--;
        return (cnt+1)/2;
    }
}
