// t.c.=O(n), s.c.=O(n)
public class Codec {

    // Encodes a tree to a single string.
    public String rserialize(TreeNode root, String str) {
        if(root==null)
            str+="null,";
        else {
            str += String.valueOf(root.val) + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }
    public String serialize(TreeNode root) {
        return rserialize(root, "");
    }

    // Decodes your encoded data to tree.
    private TreeNode rDeserialize(List<String> l) {
        if(l.get(0).equals("null")) {
            l.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = rDeserialize(l);
        root.right = rDeserialize(l);
        return root;
    }
    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
        return rDeserialize(data_list);
    }
}
