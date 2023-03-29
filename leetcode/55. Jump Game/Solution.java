// Using backtracking
// t.c.=O(2^n), s.c.=O(n), for recursion stack
public class Solution {
    public boolean canJumpFromPosition(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                return true;
            }
        }

        return false;
    }

    public boolean canJump(int[] nums) {
        return canJumpFromPosition(0, nums);
    }
}

// Using greedy approach
// t.c.=O(n), s.c.=O(1)
class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int jump=1;
        for(int i=n-2;i>=0;i--) {
            if(nums[i]>=jump)
                jump=0;
            jump++;
        }
        return jump==1?true:false;
    }
}

