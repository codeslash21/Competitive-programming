// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
// convert the tree to an undirected graph + BFS
// t.c.=O(n), s.c.=O(n)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer, List<Integer>> graph=new HashMap<>();
        Queue<Integer> queue=new LinkedList<>();
        Set<Integer> visited=new HashSet<>();
        buildGraph(root, null, graph);
        queue.offer(target.val);
        visited.add(target.val);
        int dist=0;
        while(!queue.isEmpty() && dist<k) {
            int levelSize=queue.size();
            while(levelSize-->0) {
                int value=queue.poll();
                for(int neighbor:graph.get(value)) 
                    if(!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
            }
            dist++;
        }
        return new ArrayList<>(queue);
    }
    private void buildGraph(TreeNode node, TreeNode parent, Map<Integer, List<Integer>> graph) {
        if(node==null)  return;
        graph.putIfAbsent(node.val, new ArrayList());
        if(parent!=null) {
            graph.get(parent.val).add(node.val);
            graph.get(node.val).add(parent.val);
        }
        buildGraph(node.left, node, graph);
        buildGraph(node.right, node, graph);
    }
}

// using DFS
// t.c.=O(n), s.c.=O(h)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> result=new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dfs(root, target, k);
        return result;
    }
    private int dfs(TreeNode node, TreeNode target, int k) {
        if(node==null)  return -1;
        if(node==target) {
            findDown(node, k);
            return 0;
        }
        int leftDist=dfs(node.left, target, k);
        if(leftDist!=-1) {
            if(leftDist+1==k)
                result.add(node.val);
            else
                findDown(node.right, k-leftDist-2);
            return leftDist+1;
        }
        int rightDist=dfs(node.right, target, k);
        if(rightDist!=-1) {
            if(rightDist+1==k)
                result.add(node.val);
            else
                findDown(node.left, k-rightDist-2);
            return rightDist+1;
        }
        return -1;
    }
    private void findDown(TreeNode node, int depth) {
        if(node==null || depth<0)   return;
        if(depth==0) {
            result.add(node.val);
            return;
        }
        findDown(node.left, depth-1);
        findDown(node.right, depth-1);
    }
}
