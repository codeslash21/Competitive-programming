// Recursive dfs
// t.c.=O(nlog(n/k)), s.c.+O(n), k is the width of the tree
class Solution {
    Map<Integer, List<Pair<Integer, Integer>>> map = new HashMap<>();
    int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
    private void helper(TreeNode node, int row, int col) {
        if(node==null)
            return;
        min=Math.min(min, col);
        max=Math.max(max, col);
        if(!map.containsKey(col))
            map.put(col, new ArrayList<Pair<Integer, Integer>>());
        map.get(col).add(new Pair<Integer, Integer>(row, node.val));
        helper(node.left, row+1, col-1);
        helper(node.right, row+1, col+1);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root, 0, 0);
        for(int i=min;i<=max;i++)
            if(map.containsKey(i)){
                List<Pair<Integer, Integer>> list = map.get(i);
                Collections.sort(list, new Comparator<Pair<Integer, Integer>>() {
                    @Override
                    public int compare(Pair<Integer, Integer> a, Pair<Integer, Integer> b) {
                        if(a.getKey().equals(b.getKey()))
                            return a.getValue()-b.getValue();
                        else
                            return a.getKey()-b.getKey();
                    }
                });
                List<Integer> sorted = new ArrayList<>();
                for(Pair<Integer, Integer> pair:list)
                    sorted.add(pair.getValue());
                ans.add(sorted);
            }
        return ans;
    }
}
