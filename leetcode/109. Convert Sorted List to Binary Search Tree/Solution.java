// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
// using array
// t.c.=O(n), s.c.=O(n)
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> values=new ArrayList<>();
        // copy linked list values into the list
        while(head!=null) {
            values.add(head.val);
            head=head.next;
        }
        return buildTree(values, 0, values.size()-1);
    }
    private TreeNode buildTree(List<Integer> values, int start, int end) {
        if(start>end)   return null;
        int mid=start+(end-start)/2;
        TreeNode node=new TreeNode(values.get(mid));
        node.left=buildTree(values, start, mid-1);
        node.right=buildTree(values, mid+1, end);
        return node;
    }
}

// in-order traversal
// t.c.=O(n), s.c.=O(logn)
class Solution {
    ListNode current;
    public TreeNode sortedListToBST(ListNode head) {
        int size=0;
        ListNode node=head;
        while(node!=null) {
            size++;
            node=node.next;
        }
        current=head;
        return buildTree(0, size-1);
    }
    private TreeNode buildTree(int start, int end) {
        if(start>end)   return null;
        int mid=start+(end-start)/2;
        TreeNode leftChild=buildTree(start, mid-1);
        TreeNode root=new TreeNode(current.val);
        root.left=leftChild;
        current=current.next;
        root.right=buildTree(mid+1, end);
        return root;
    }
}
