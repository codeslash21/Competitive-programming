// Using KMP algorithm
// t.c.=O(n), s.c.=O(m)
class Solution {
    public int strStr(String s, String r) {
        int n=s.length();
        int m=r.length();
        if(n<m)
            return -1;
        int[] shifts = new int[m+1];
        Arrays.fill(shifts, 1);
        int left=-1;
        for(int right=0;right<m;right++) {
            while(left>=0 && r.charAt(left)!=r.charAt(right))
                left-=shifts[left];
            shifts[right+1] = right-left++;
        }
        int matchLen=0;
        for(int i=0;i<n;i++) {
            while(matchLen>=0 && s.charAt(i)!=r.charAt(matchLen))
                matchLen-=shifts[matchLen];
            if(++matchLen==m)
                return (i-matchLen+1);
        }
        return -1;
    }
}
