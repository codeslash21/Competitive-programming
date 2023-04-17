// Using two stack
class MyQueue {
    Stack<Integer> first;
    Stack<Integer> second;
    public MyQueue() {
        first = new Stack<Integer>();
        second = new Stack<Integer>();
    }
    
    public void push(int x) {
        first.add(x);
    }
    
    public int pop() {
        if(second.isEmpty())
            while(!first.isEmpty())
                second.add(first.pop());
        return second.pop();
    }
    
    public int peek() {
        if(second.isEmpty())
            while(!first.isEmpty())
                second.add(first.pop());
        return second.peek();
    }
    
    public boolean empty() {
        return second.isEmpty() && first.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
