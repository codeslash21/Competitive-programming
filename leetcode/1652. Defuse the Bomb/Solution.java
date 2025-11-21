// https://leetcode.com/problems/defuse-the-bomb/description/
// using bruteforce
// t.c.=O(n*k), s.c.=O(n)
class Solution {
    public int[] decrypt(int[] code, int k) {
        int len=code.length;
        int[] result=new int[len];
        if(k==0)
            return result;
        for(int i=0;i<len;i++)
            if(k>0)
                for(int j=1;j<=k;j++)
                    result[i]+=code[(i+j)%len];
            else
                for(int j=k;j<0;j++)
                    result[i]+=code[(i+j+len)%len];
        return result;
    }
}

// sliding window
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int[] decrypt(int[] code, int k) {
        int len=code.length, start=k>0?1:len+k, end=k>0?k:len-1, sum=0;
        int[] res=new int[len];
        if(k==0)
            return res;
        for(int i=start;i<=end;i++)
            sum+=code[i];
        for(int i=0;i<len;i++) {
            res[i]=sum;
            sum-=code[start%len];
            sum+=code[(end+1)%len];
            start++;
            end++;
        }
        return res;
    }
}
