// Using brute force method
// t.c.=O(n^3), s.c.=O(min(n,m)) where m is the unique characters
class Solution {
    public boolean noRepeating(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for(int i=start; i<=end; i++){
            char c = s.charAt(i);
            if(set.contains(c))
                return false;
            set.add(c);
        }
        return true;
    }
    public int lengthOfLongestSubstring(String s) {
        int n=s.length(), maxLen=Integer.MIN_VALUE;
        if(n==0)
            return 0;
        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++)
                if(noRepeating(s, i, j))
                    maxLen=Math.max(maxLen, j-i+1);
        }
        return maxLen;
    }
}

// using sliding window
// t.c.=O(2n)=O(n) in worst case each char can be visited twice when all the chars are same in s, s.c.=O(min(n,m))
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int left=0, right=0, maxLen=0;
        Map<Character, Integer> map = new HashMap<>();
        while(right<n) {
            char r = s.charAt(right);
            map.put(r, map.getOrDefault(r, 0)+1);
            while(map.get(r)>1) {
                char l=s.charAt(left);
                map.put(l, map.get(l)-1);
                left++;
            }
            maxLen=Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }
}

// Optimized sliding window
// t.c.=O(n), s.c.=O(min(m,n))
class Solution {
     public int lengthOfLongestSubstring(String s) {
        int n=s.length(), maxLen=0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0,j=0;j<n;j++) {
            char c=s.charAt(j);
            if(map.containsKey(c))
                i=Math.max(map.get(c), i);
            map.put(c, j+1);
            maxLen=Math.max(maxLen, j-i+1);
        }
        return maxLen;
    }
}
