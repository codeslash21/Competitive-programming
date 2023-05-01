// Using hashmap
// t.c.=O(n), s.c.=O(n)
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    private void traverse(TreeNode root) {
        if(root==null)
            return;
        map.put(root.val, map.getOrDefault(root.val, 0)+1);
        traverse(root.left);
        traverse(root.right);
    }
    public int[] findMode(TreeNode root) {
        traverse(root);
        List<Integer> l = new ArrayList<>();
        int max = Collections.max(map.values());
        for(Integer k : map.keySet())
            if(map.get(k)==max)
                l.add(k);
        return l.stream().mapToInt(i->i).toArray();
    }
}
