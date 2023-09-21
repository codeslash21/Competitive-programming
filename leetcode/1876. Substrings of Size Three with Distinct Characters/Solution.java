// t.c.=O(n), s.c.=O(1)
class Solution {
    public int countGoodSubstrings(String s) {
        int n=s.length(), cnt=0, res=0;
        int[] arr = new int[26];
        for(int i=0;i<n;i++) {
            char c=s.charAt(i);
            if(i>2 && --arr[s.charAt(i-3)-'a']==0) 
                cnt--;
            arr[c-'a']++;
            if(arr[c-'a']==1)
                cnt++;
            if(cnt==3)
                res++;
        }
        return res;
    }
}
