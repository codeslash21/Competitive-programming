// using sliding window
// t.c.=O(n1+n2), s.c.=O(1)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1=s1.length(), len2=s2.length(), seen=0;
        int[] freq1 = new int[26], freq2 = new int[26];
        if(len2<len1)
            return false;
        for(int i=0;i<len1;i++)
            freq1[s1.charAt(i)-'a']++;
        for(int i=0;i<len1-1;i++){
            int c=s2.charAt(i)-'a';
            freq2[c]++;
            if(freq1[c]>=freq2[c])
                seen++;
        }
        for(int i=len1-1;i<len2;i++) {
            int c=s2.charAt(i)-'a';
            freq2[c]++;
            if(freq1[c]>=freq2[c])
                seen++;
            if(seen==len1)
                return true;
            c=s2.charAt(i+1-len1)-'a';
            if(freq1[c]>=freq2[c])
                seen--;
            freq2[c]--;
        }
        return false;
    }
}
