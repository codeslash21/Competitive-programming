// https://leetcode.com/problems/get-equal-substrings-within-budget/description/
// using binary search + sliding window
// t.c.=O(nlogn), s.c.=O(1)
class Solution {
    public boolean validWindow(String s, String t, int windowSize, int maxCost) {
        int len=s.length(), left=0, right=0, sum=0;
        while(right<len) {
            sum+=Math.abs(s.charAt(right)-t.charAt(right));
            if(right>=windowSize)
                sum-=Math.abs(s.charAt(right-windowSize)-t.charAt(right-windowSize));
            if(right>=windowSize-1 && sum<=maxCost)
                return true;
            right++;
        }
        return false;
    }
    public int equalSubstring(String s, String t, int maxCost) {
        int len=s.length(), left=0, right=len;
        while(left<=right) {
            int mid=left+(right-left)/2;
            if(validWindow(s, t, mid, maxCost))
                left=mid+1;
            else
                right=mid-1;
        }
        return left==0?left:left-1;
    }
}

// sliding window
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int len=s.length(), left=0, right=0, sum=0;
        while(right<len) {
            sum+=Math.abs(s.charAt(right)-t.charAt(right++));
            if(sum>maxCost)
                sum-=Math.abs(s.charAt(left)-t.charAt(left++));
        }
        return len-left;
    }
}
