// using hashmap
// t.c.=O(n), s.c.=O(n)
class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Integer> first = new HashMap<>();
        Map<Integer, Node> second = new HashMap<>();
        Node dummy = new Node(0), write=dummy, curr=head;
        int i=0;
        while(curr!=null) {
            write = write.next = new Node(curr.val);
            first.put(curr, i);
            second.put(i++, write);
            curr=curr.next;
        }
        curr = head;
        Node secondCurr = dummy.next;
        while(curr!=null) {
            if(curr.random!=null)
                secondCurr.random = second.get(first.get(curr.random));
            curr=curr.next;
            secondCurr = secondCurr.next;
        }
        return dummy.next;
    }
}

// using recursion
// t.c.=O(n), s.c.=O(n)
class Solution {
    Map<Node, Node> visited = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        if(visited.containsKey(head))
            return this.visited.get(head);
        Node node = new Node(head.val);
        visited.put(head, node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        return node;
    }
}

// Iterative version
// t.c.=O(n), s.c.=O(n)
class Solution {
    Map<Node, Node> visited = new HashMap<>();
    private Node getCloneNode(Node node) {
        if(node==null)
            return null;
        if(visited.containsKey(node))
            return visited.get(node);
        else {
            visited.put(node, new Node(node.val));
            return visited.get(node);
        }
    }
    public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        Node newNode = new Node(head.val), oldNode = head;
        visited.put(oldNode, newNode);
        while(oldNode!=null) {
            newNode.random=getCloneNode(oldNode.random);
            newNode.next=getCloneNode(oldNode.next);
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return visited.get(head);
    }
}

// Iterative approach without extra space
// t.c.=O(n), s.c.=O(1)
class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        Node ptr = head;
        while(ptr!=null) {
            Node node = new Node(ptr.val);
            node.next=ptr.next;
            ptr.next=node;
            ptr=node.next;
        }
        ptr=head;
        while(ptr!=null) {
            ptr.next.random = ptr.random!=null? ptr.random.next : null;
            ptr=ptr.next.next;
        }
        Node ptrOld=head, ptrNew=head.next, newHead=head.next;
        while(ptrOld!=null) {
            ptrOld.next=ptrOld.next.next;
            ptrNew.next=ptrNew.next==null? null : ptrNew.next.next;
            ptrOld = ptrOld.next;
            ptrNew = ptrNew.next;
        }
        return newHead;
    }
}
