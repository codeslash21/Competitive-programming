// Using postorder traversal
// t.c.=O(n), s.c.=O(n)
public class Codec {

    // Encodes a tree to a single string.
    private StringBuilder postOrder(TreeNode root, StringBuilder sb) {
        if(root==null)
            return sb;
        postOrder(root.left, sb);
        postOrder(root.right, sb);
        sb.append(root.val);
        sb.append(',');
        return sb;
    }
    public String serialize(TreeNode root) {
        StringBuilder sb = postOrder(root, new StringBuilder());
        if(sb.length()>0)
            sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    private TreeNode helper(Integer lower, Integer upper, Stack<Integer> nums) {
        if(nums.isEmpty())
            return null;
        int val = nums.peek();
        if(val<lower || val>upper)
            return null;
        nums.pop();
        TreeNode node = new TreeNode(val);
        node.right = helper(val, upper, nums);
        node.left = helper(lower, val, nums);
        return node;
    }
    public TreeNode deserialize(String data) {
        if(data.isEmpty())
            return null;
        Stack<Integer> stack = new Stack<>();
        for(String s : data.split(","))
            stack.add(Integer.valueOf(s));
        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE, stack);
    }
}

// Optimize space by converting int to 4-B string
// t.c.=O(n), s.c.=O(n)
public class Codec {

    // Encodes a tree to a single string.
    private void postOrder(TreeNode root, StringBuilder sb) {
        if(root==null)
            return;
        postOrder(root.left, sb);
        postOrder(root.right, sb);
        sb.append(intToString(root.val));
    }
    private String intToString(int x) {
        char[] bytes = new char[4];
        for(int i=3;i>-1;i--)
            bytes[3-i] = (char)(x>>i*8 & 0xff);
        return new String(bytes);
    }
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        postOrder(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    private TreeNode helper(Integer lower, Integer upper, Stack<Integer> nums) {
        if(nums.isEmpty())
            return null;
        int val = nums.peek();
        if(val<lower || val>upper)
            return null;
        nums.pop();
        TreeNode node = new TreeNode(val);
        node.right = helper(val, upper, nums);
        node.left = helper(lower, val, nums);
        return node;
    }
    private int stringToInt(String byteStr) {
        int result=0;
        for(char c : byteStr.toCharArray()) 
            result = (result<<8)+(int)c;
        return result;
    }
    public TreeNode deserialize(String data) {
        Stack<Integer> stack = new Stack<>();
        int n = data.length();
        for(int i=0;i<(int)(n/4);i++)
            stack.add(stringToInt(data.substring(4*i, 4*i+4)));
        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE, stack);
    }
}
