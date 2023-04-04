// verticle Scanning all the strings
// t.c.=O(m), s.c.=O(1), where m is the length of all the strings 
class Solution {
    public String longestCommonPrefix(String[] strs) {
        for(int i=0;i<strs[0].length();i++) {
            char c = strs[0].charAt(i);
            for(int j=1;j<strs.length;j++)
                if(i==strs[j].length() || strs[j].charAt(i)!=c)
                    return strs[0].substring(0,i);
        }
        return strs[0];
    }
}

// Using horizontal scanning of strings
// t.c.=O(m), s.c.=O(n)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for(int i=1;i<strs.length;i++) {
            while(strs[i].indexOf(prefix)!=0) {
                prefix=prefix.substring(0, prefix.length()-1);
                if(prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }
}

// devide and conquer
// t.c.=O(s) t.c.=2*T(n/2)+O(m) where m is the length of each string in worst case all the strings are same, s.c.=O(mlogn) stack=O(logn) and in each recursive call we need to store prefix of length O(m)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        return longestCommonPrefix(strs, 0, strs.length-1);
    }
    public String longestCommonPrefix(String[] strs, int start, int end) {
        if(start==end)
            return strs[start];
        int mid=(start+end)/2;
        String lcpLeft=longestCommonPrefix(strs, start, mid);
        String lcpRight=longestCommonPrefix(strs, mid+1, end);
        return commonPrefix(lcpLeft, lcpRight);
    }
    public String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for(int i=0;i<min;i++) 
            if(left.charAt(i)!=right.charAt(i))
                return left.substring(0, i);
        return left.substring(0, min);
    }
}
