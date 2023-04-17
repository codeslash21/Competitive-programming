// Linear solution
// t.c.=O(n), s.c.=O(n)
class Solution {
    private void swap(char[] nums, int a, int b) {
        char temp = nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    private void reverse(char[] nums, int start, int end) {
        while(start<end)
            swap(nums, start++, end--);
    }
    public int nextGreaterElement(int n) {
        char[] c = ("" + n).toCharArray();
        int len=c.length;
        int i=len-2, j=len-1;
        while(i>=0 && c[i]>=c[i+1])
            i--;
        if(i<0)
            return -1;
        while(j>i && c[j]<=c[i])
            j--;
        swap(c, i, j);
        reverse(c, i+1, len-1);
        try {
            return Integer.parseInt(new String(c));
        } catch(Exception e) {
            return -1;
        }
    }
}
