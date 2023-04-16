// Using one stack
// t.c.=O(1), s.c.=O(n)
class MinStack {
    Stack<int[]> stack = new Stack<>();
    public MinStack() { }
    public void push(int val) {
        if(stack.isEmpty()) 
            stack.push(new int[]{val, val});
        else {
            int currMin = stack.peek()[1];
            stack.push(new int[]{val, Math.min(val, currMin)});
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
}

// using two stack
// t.c.=O(1), s.c.=O(n)
class MinStack {
    Stack<int[]> minStack = new Stack<>();
    Stack<Integer> stack = new Stack<>();
    public MinStack() { }
    public void push(int val) {
        if(minStack.isEmpty() || val<minStack.peek()[0])
            minStack.push(new int[]{val, 1});
        else if(minStack.peek()[0]==val)
            minStack.peek()[1]++;
        stack.push(val);
    }
    
    public void pop() {
        if(stack.peek().equals(minStack.peek()[0]))
            minStack.peek()[1]--;
        if(minStack.peek()[1]==0)
            minStack.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek()[0];
    }
}
