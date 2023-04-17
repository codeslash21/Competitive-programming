// Using one queue
// insert=O(n), pop=O(1)
class MyStack {
    Queue<Integer> first;

    public MyStack() {
        first = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        first.add(x);
        int size=first.size();
        while(size-->1)
            first.add(first.remove());
    }
    
    public int pop() {
        return first.remove();
    }
    
    public int top() {
        return first.element();
    }
    
    public boolean empty() {
        return first.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
