// Using DFS recursion
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return 1;
        int depth=Integer.MAX_VALUE;
        if(root.right!=null)
            depth=Math.min(minDepth(root.right), depth);
        if(root.left!=null)
            depth=Math.min(minDepth(root.left), depth);
        return depth+1;
    }
}

// Using DFS iterative approach
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(root, 1));
        int min_depth=Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            Pair<TreeNode, Integer> curr = queue.pollLast();
            root = curr.getKey();
            int currDepth = curr.getValue();
            if(root.left==null && root.right==null)
                min_depth=Math.min(min_depth, currDepth);
            if(root.left!=null)
                queue.add(new Pair(root.left, currDepth+1));
            if(root.right!=null)
                queue.add(new Pair(root.right, currDepth+1));
        }
        return min_depth;
    }
}

// Using BFS iterative approach
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(root, 1));
        int min_depth=Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            Pair<TreeNode, Integer> curr = queue.remove();
            root = curr.getKey();
            int currDepth = curr.getValue();
            if(root.left==null && root.right==null)
                min_depth=Math.min(min_depth, currDepth);
            if(root.left!=null)
                queue.add(new Pair(root.left, currDepth+1));
            if(root.right!=null)
                queue.add(new Pair(root.right, currDepth+1));
        }
        return min_depth;
    }
}

