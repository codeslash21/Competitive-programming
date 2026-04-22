// https://leetcode.com/problems/path-sum-iii/description/
// using brute force
// t.c.=O(n^2), s.c.=O(n)
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null)  return 0;
        return countFromNode(root, 0, targetSum)+pathSum(root.left, targetSum)+pathSum(root.right, targetSum);
    }

    private int countFromNode(TreeNode root, long currSum, int targetSum) {
        if(root==null)  return 0;
        int count=0;
        currSum+=root.val;
        if(currSum==targetSum)  count++;
        return count+countFromNode(root.left, currSum, targetSum)+countFromNode(root.right, currSum, targetSum);
    }
}

// using prefix sum
// t.c.=O(n), s.c.=O(n)
class Solution {
    int count=0;
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSumMap=new HashMap<>();
        prefixSumMap.put(0L, 1);
        dfs(root, 0, prefixSumMap, targetSum);
        return count;
    }
    private void dfs(TreeNode node, long currSum, Map<Long, Integer> prefixSumMap, int targetSum) {
        if(node==null)  return;
        currSum+=node.val;
        count+=prefixSumMap.getOrDefault(currSum-targetSum, 0);
        prefixSumMap.put(currSum, prefixSumMap.getOrDefault(currSum, 0)+1);
        dfs(node.left, currSum, prefixSumMap, targetSum);
        dfs(node.right, currSum, prefixSumMap, targetSum);
        prefixSumMap.put(currSum, prefixSumMap.get(currSum)-1);
    }
}
