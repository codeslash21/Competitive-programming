// https://leetcode.com/problems/permutation-in-string/description/
// using bruteforce method, checking all possible permutations
// t.c.=O(m!*m*n), s.c.=O(m^2), m=len(s1), n=len(s2)
class Solution {
    public String swap(String s, int idx1, int idx2) {
        if(idx1==idx2)
            return s;
        char[] chars=s.toCharArray();
        char temp=chars[idx1];
        chars[idx1]=chars[idx2];
        chars[idx2]=temp;
        return new String(chars);
    }
    public boolean permute(String s1, String s2, int idx1) {
        int len=s1.length();
        if(idx1==len-1 && s2.indexOf(s1)>=0)
            return true;
        else {
            for(int idx2=idx1;idx2<len;idx2++) {
                s1=swap(s1, idx1, idx2);
                if(permute(s1, s2, idx1+1))
                    return true;
                s1=swap(s1, idx1, idx2);
            }
        }
        return false;
    }
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
            return false;
        return permute(s1, s2, 0);
    }
}

// using sorting
// t.c.=O((n-m)*mlogm), s.c.=O((n-m)*(m+logm))
class Solution {
    public String sort(String s) {
        char[] chars=s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    public boolean checkInclusion(String s1, String s2) {
        int len1=s1.length(), len2=s2.length();
        s1=sort(s1);
        for(int i=0;i<=len2-len1;i++)
            if(s1.equals(sort(s2.substring(i, i+len1))))
                return true;
        return false;
    }
}

// using frequency table
// t.c.=O(m+(n-m)*m), s.c.=O(n-m), m=len(s1), n=len(s2)
class Solution {
    public boolean matchFreq(int[] arr1, int[] arr2) {
        for(int i=0;i<26;i++)
            if(arr1[i]!=arr2[i])
                return false;
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int len1=s1.length(), len2=s2.length();
        if(len1>len2)
            return false;
        int[] freq1=new int[26];
        for(int i=0;i<len1;i++)
            freq1[s1.charAt(i)-'a']++;
        for(int i=0;i<=len2-len1;i++) {
            int[] freq2=new int[26];
            for(int j=i;j<i+len1;j++)
                freq2[s2.charAt(j)-'a']++;
            if(matchFreq(freq1, freq2))
                return true;
        }
        return false;
    }
}

// using sliding window
// t.c.=O(m+n), s.c.=O(1), m=len(s1), n=len(s2)
class Solution {
    public boolean matchFreq(int[] arr1, int[] arr2) {
        for(int i=0;i<26;i++)
            if(arr1[i]!=arr2[i])
                return false;
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int len1=s1.length(), len2=s2.length();
        if(len1>len2)
            return false;
        int[] freq1=new int[26], freq2=new int[26];
        for(int i=0;i<len1;i++)
            freq1[s1.charAt(i)-'a']++;
        for(int i=0;i<len1-1;i++)
            freq2[s2.charAt(i)-'a']++;
        for(int i=len1-1;i<len2;i++) {
            freq2[s2.charAt(i)-'a']++;
            if(matchFreq(freq1, freq2))
                return true;
            freq2[s2.charAt(i-len1+1)-'a']--;
        }
        return false;
    }
}
