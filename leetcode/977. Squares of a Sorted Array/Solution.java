// using two pointers
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length, start=0, end=n-1, i=n-1;
        int[] op = new int[n];
        while(start<=end) {
            if(Math.abs(nums[start])>Math.abs(nums[end])){
                op[i--]=(nums[start]*nums[start]);
                start++;
            }
            else{
                op[i--]=(nums[end]*nums[end]);
                end--;
            }
        }
        return op;
    }
}
