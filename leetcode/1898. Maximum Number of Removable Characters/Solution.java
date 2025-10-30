// https://leetcode.com/problems/maximum-number-of-removable-characters/description/
//  t.c.=O(Min(lenS, lenP)logN), s.c.=O(1), N=len(removable)
class Solution {
    public boolean stillSubsequence(char[] letters, String p) {
        int idx1=0, idx2=0, len1=letters.length, len2=p.length();
        while(idx1++<len1 && idx2<len2)
            if(letters[idx1-1]==p.charAt(idx2))
                idx2++;
        return idx2==len2;
    }
    public int maximumRemovals(String s, String p, int[] removable) {
        char[] letters=s.toCharArray();
        int left=0, right=removable.length;
        while(left<=right) {
            int mid=left+(right-left)/2;
            for(int i=0;i<mid;i++)
                letters[removable[i]]='*';
            if(stillSubsequence(letters, p))
                left=mid+1;
            else {
                for(int i=0;i<mid;i++)
                    letters[removable[i]]=s.charAt(removable[i]);
                right=mid-1;
            }
        }
        return right;
    }
}
