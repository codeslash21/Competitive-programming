// Using sorting
// t.c.=O(nlogn), s.c.=O(n)
class Solution {
    public boolean isAnagram(String s, String t) {
        int len1=s.length(), len2=t.length();
        if(len1!=len2)
            return false;
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}

// using counter 
// t.c.=O(n), s.c.=O(1)
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        int len1=s.length(), len2=t.length();
        if(len1!=len2)
            return false;
        for(int i=0; i<len1; i++)
            arr[s.charAt(i)-'a']+=1;
        for(int i=0; i<len2; i++) {
            if(arr[t.charAt(i)-'a']==0)
                return false;
            arr[t.charAt(i)-'a']-=1;
        }
        return true;
    }
}
