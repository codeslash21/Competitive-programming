// using recursion
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int maxDepth(Node root) {
        if(root==null)
            return 0;
        int res=0;
        for(int i=0;i<root.children.size();i++)
            res=Math.max(res, maxDepth(root.children.get(i)));
        return 1+res;
    }
}

// using iterative approach
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int maxDepth(Node root) {
        Queue<Pair<Node, Integer>> queue = new LinkedList<>();
        if(root!=null)
            queue.add(new Pair(root, 1));
        int depth=0;
        while(!queue.isEmpty()) {
            Pair<Node, Integer> curr = queue.poll();
            root = curr.getKey();
            int currDepth = curr.getValue();
            depth = Math.max(depth, currDepth);
            for(Node node:root.children)
                queue.offer(new Pair(node, currDepth+1));
        }
        return depth;
    }
}
