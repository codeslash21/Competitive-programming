// https://leetcode.com/problems/design-hashset/description/
// using linkedlist
// t.c.=O(N/K), s.c.=O(N+K), N=number of all possible values, K=number of bucket.
class Bucket {
    private LinkedList<Integer> bucket;
    public Bucket() {
        bucket=new LinkedList<>();
    }
    public void add(Integer key) {
        int index=bucket.indexOf(key);
        if(index==-1)
            bucket.addFirst(key);
    }
    public void remove(Integer key) {
        bucket.remove(key);
    }
    public boolean contains(Integer key) {
        return bucket.indexOf(key)!=-1;
    }
}
class MyHashSet {
    private int keyRange;
    private Bucket[] bucketArray;
    public MyHashSet() {
        keyRange=769;
        bucketArray=new Bucket[keyRange];
        for(int i=0;i<keyRange;i++)
            bucketArray[i]=new Bucket();
    }
    
    public int _hash(int key) {
        return key%keyRange;
    }
    public void add(int key) {
        int bucketIndex=_hash(key);
        bucketArray[bucketIndex].add(key);
    }
    
    public void remove(int key) {
        int bucketIndex=_hash(key);
        bucketArray[bucketIndex].remove(key);
    }
    
    public boolean contains(int key) {
        int bucketIndex=_hash(key);
        return bucketArray[bucketIndex].contains(key);
    }
}

// using bst
// t.c.=O(log(n/k)), s.c.=O(n+k)
class Bucket {
    private BSTree tree;
    public Bucket() {
        tree=new BSTree();
    }
    public void add(Integer key) {
        tree.root=tree.insertNode(tree.root, key);
    }
    public void remove(Integer key) {
        tree.root=tree.deleteNode(tree.root, key);
    }
    public boolean contains(Integer key) {
        return tree.searchNode(tree.root, key)!=null;
    }
}
class TreeNode {
    int val;
    TreeNode left, right;
    public TreeNode(int val) {
        this.val=val;
    }
}
class BSTree {
    TreeNode root;
    public BSTree() {
        root=null;
    }
    public TreeNode searchNode(TreeNode root, int val) {
        if(root==null || root.val==val)
            return root;
        return val<root.val? searchNode(root.left, val) : searchNode(root.right, val);
    }
    public TreeNode insertNode(TreeNode root, int val) {
        if(root==null)
            return new TreeNode(val);
        if(val>root.val)
            root.right=insertNode(root.right, val);
        else if(val<root.val)
            root.left=insertNode(root.left, val);
        return root;
    }
    public int successor(TreeNode root) {
        root=root.right;
        while(root.left!=null)
            root=root.left;
        return root.val;
    }
    public int predecessor(TreeNode root) {
        root=root.left;
        while(root.right!=null)
            root=root.right;
        return root.val;
    }
    public TreeNode deleteNode(TreeNode root, int val) {
        if(root==null)
            return root;
        if(val>root.val)
            root.right=deleteNode(root.right, val);
        else if(val<root.val)
            root.left=deleteNode(root.left, val);
        else {
            if(root.left==null && root.right==null)
                root=null;
            else if(root.right!=null) {
                root.val=successor(root);
                root.right=deleteNode(root.right, root.val);
            } else {
                root.val=predecessor(root);
                root.left=deleteNode(root.left, root.val);
            }
        }
        return root;
    }
}
class MyHashSet {
    private int keyRange;
    private Bucket[] bucketArray;
    public MyHashSet() {
        keyRange=769;
        bucketArray=new Bucket[keyRange];
        for(int i=0;i<keyRange;i++)
            bucketArray[i]=new Bucket();
    }
    
    public int _hash(int key) {
        return key%keyRange;
    }
    public void add(int key) {
        int bucketIndex=_hash(key);
        bucketArray[bucketIndex].add(key);
    }
    
    public void remove(int key) {
        int bucketIndex=_hash(key);
        bucketArray[bucketIndex].remove(key);
    }
    
    public boolean contains(int key) {
        int bucketIndex=_hash(key);
        return bucketArray[bucketIndex].contains(key);
    }
}

