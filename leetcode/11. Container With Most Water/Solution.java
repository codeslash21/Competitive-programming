// using two pointers technique
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int left=0, right=n-1, len=n-1, max=0;
        while(left<right) {
            int curr = Math.min(height[left], height[right])*len;
            max=Math.max(max, curr);
            if(height[left]<=height[right])
                left++;
            else
                right--;
            len--;
        }
        return max;
    }
}
