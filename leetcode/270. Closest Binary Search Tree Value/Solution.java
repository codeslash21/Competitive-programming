// Using binary search
// t.c.=O(d), s.c.=O(1)
class Solution {
    public int closestValue(TreeNode root, double target) {
        int close=root.val;
        while(root!=null) {
            int val=root.val;
            close=Math.abs(val-target)<=Math.abs(close-target)?val:close;
            root=root.val<target?root.right:root.left;
        }
        return close;
    }
}
