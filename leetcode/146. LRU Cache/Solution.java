// https://leetcode.com/problems/lru-cache/description/
// t.c.=O(1), s.c.=O(capacity)
class Node {
    int key, val;
    Node next, prev;
    public Node(int key, int val) {
        this.key=key;
        this.val=val;
    }
}
class LRUCache {
    int capacity;
    Map<Integer, Node> map;
    Node head, tail;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
        head=new Node(-1, -1);
        tail=new Node(-1, -1);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        Node node=map.get(key);
        removeNode(node);
        addNode(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node oldNode=map.get(key);
            removeNode(oldNode);
        }
        Node newNode=new Node(key, value);
        map.put(key, newNode);
        addNode(newNode);
        if(map.size()>capacity) {
            Node nodeToDelete=head.next;
            removeNode(nodeToDelete);
            map.remove(nodeToDelete.key);
        }
    }
    private void removeNode(Node node) {
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    private void addNode(Node node) {
        Node previousNode=tail.prev;
        previousNode.next=node;
        node.prev=previousNode;
        node.next=tail;
        tail.prev=node;
    }
}

// using built in LinkedHashMap data structure
// t.c.=O(1), s.c.=O(capacity)
class LRUCache {
    int capacity;
    LinkedHashMap<Integer, Integer> map;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new LinkedHashMap<>(5, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(
                Map.Entry<Integer, Integer> eldest
            ) {
                return size() > capacity;
            }
        };
    }
    
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        map.put(key, value);
    }
}
