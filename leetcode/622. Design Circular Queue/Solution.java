// https://leetcode.com/problems/design-circular-queue/description/
// using array
// t.c.=O(1), s.c.=O(k)
class MyCircularQueue {
    private int[] queue;
    private int headIndex, count, capacity;
    public MyCircularQueue(int k) {
        queue=new int[k];
        headIndex=0;
        count=0;
        capacity=k;
    }
    
    public boolean enQueue(int value) {
        if(count==capacity)
            return false;
        queue[(headIndex+count)%capacity]=value;
        count++;
        return true;
    }
    
    public boolean deQueue() {
        if(count==0)
            return false;
        headIndex=(headIndex+1)%capacity;
        count--;
        return true;
    }
    
    public int Front() {
        if(count==0)
            return -1;
        return queue[headIndex];
    }
    
    public int Rear() {
        if(count==0)
            return -1;
        return queue[(headIndex+count-1)%capacity];
    }
    
    public boolean isEmpty() {
        return count==0;
    }
    
    public boolean isFull() {
        return count==capacity;
    }
}


// using linkedlist
// t.c.=O(1), s.c.=O(k)
class Node {
    public int value;
    public Node next;
    public Node(int value) {
        this.value=value;
    }
}
class MyCircularQueue {
    private Node head, tail;
    private int cnt, capacity;
    public MyCircularQueue(int k) {
        cnt=0;
        capacity=k;
    }
    
    public boolean enQueue(int value) {
        if(cnt==capacity)
            return false;
        Node newNode=new Node(value);
        if(cnt==0)
            head=tail=newNode;
        else {
            tail.next=newNode;
            tail=tail.next;
        }
        cnt++;
        return true;
    }
    
    public boolean deQueue() {
        if(cnt==0)
            return false;
        head=head.next;
        cnt--;
        return true;
    }
    
    public int Front() {
        if(cnt==0)
            return -1;
        return head.value;
    }
    
    public int Rear() {
        if(cnt==0)
            return -1;
        return tail.value;
    }
    
    public boolean isEmpty() {
        return cnt==0;
    }
    
    public boolean isFull() {
        return cnt==capacity;
    }
}


