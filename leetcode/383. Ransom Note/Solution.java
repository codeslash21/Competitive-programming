// using array
// t.c.=O()n), s.c.=O(1)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] alpha = new int[26];
        int len1=ransomNote.length(), len2=magazine.length();
        if(len1>len2)
            return false;
        for(int i=0;i<len2;i++) {
            alpha[magazine.charAt(i)-'a']++;
            if(i<len1)
                alpha[ransomNote.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++)
            if(alpha[i]<0)
                return false;
        return true;
    }
}
