// Using linear scan
// t.c.=O(n+m), s.c.=O(1), where n is the length of S and m is the max length of word
class Solution {
    public boolean checkStretchy(String s, String word) {
        int len1=s.length(), len2=word.length();
        if(len1<len2)
            return false;
        int i=0, j=0;
        while(i<len1 & j<len2) {
            if(s.charAt(i)!=word.charAt(j))
                return false;
            else {
                int l1=getSubstringLength(s, i);
                int l2=getSubstringLength(word, j);
                if(l1<3 && l1!=l2 || l1>=3 && l2>l1)
                    return false;
                i+=l1;
                j+=l2;
            }
        }
        return i==s.length() && j==word.length();
    }
    public int getSubstringLength(String s, int i) {
        int j=i;
        while(j<s.length() && s.charAt(i)==s.charAt(j))
            j++;
        return j-i;
    }
    public int expressiveWords(String s, String[] words) {
        int res=0;
        for(String word:words)
            if(checkStretchy(s, word))
                res++;
        return res;
    }
}
