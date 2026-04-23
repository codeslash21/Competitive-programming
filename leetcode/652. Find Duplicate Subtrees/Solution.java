// https://leetcode.com/problems/find-duplicate-subtrees/description/
// using serialization
// t.c.=O(n^2), s.c.=O(n^2)
class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result=new ArrayList<>();
        Map<String, Integer> count=new HashMap<>();
        serialize(root, count, result);
        return result;
    }
    private String serialize(TreeNode node, Map<String, Integer> count, List<TreeNode> result) {
        if(node==null)  return "#";
        String serialized=serialize(node.left, count, result)+","
                            +serialize(node.right, count, result)+","
                            +node.val;
        count.put(serialized, count.getOrDefault(serialized, 0)+1);
        if(count.get(serialized)==2)
            result.add(node);
        return serialized;

    }
}

// t.c.=O(n), s.c.=O(n)
class Solution {
    int nextId=1;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result=new ArrayList<>();
        Map<String, Integer> toupleToId=new HashMap<>();
        Map<Integer, Integer> idCount=new HashMap<>();
        dfs(root, toupleToId, idCount, result);
        return result;
    }
    private Integer dfs(TreeNode node, Map<String, Integer> toupleToId, Map<Integer, Integer> idCount, List<TreeNode> result) {
        if(node==null)  return 0;
        String key=dfs(node.left, toupleToId, idCount, result)+","
                    +node.val+","+
                    +dfs(node.right, toupleToId, idCount, result);
        toupleToId.putIfAbsent(key, nextId++);
        int id=toupleToId.get(key);
        idCount.put(id, idCount.getOrDefault(id, 0)+1);
        if(idCount.get(id)==2)
            result.add(node);
        return id;
    }
}
