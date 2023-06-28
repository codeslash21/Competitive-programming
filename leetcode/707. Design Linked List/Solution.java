class Node {
    int val;
    Node next;
    Node(int val) {
        this.val=val;
    }
}
class MyLinkedList {
    Node head;
    int len;
    public MyLinkedList() {
        head=new Node(0);
        len=0;
    }
    
    public int get(int index) {
        if(index>=len || index<0)
            return -1;
        Node curr=head;
        for(int i=0;i<=index;i++)
            curr=curr.next;
        return curr.val;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    public void addAtTail(int val) {
        addAtIndex(len, val);
    }
    
    public void addAtIndex(int index, int val) {
        if(index>len || index<0)
            return;
        Node node = new Node(val);
        Node prev=head;
        for(int i=0;i<index;i++) 
            prev=prev.next;
        node.next=prev.next;
        prev.next=node;
        len++;
    }
    
    public void deleteAtIndex(int index) {
        if(index>=len || index<0)
            return;
        Node prev=head;
        for(int i=0;i<index;i++)
            prev=prev.next;
        prev.next=prev.next.next;
        len--;
    }
}
