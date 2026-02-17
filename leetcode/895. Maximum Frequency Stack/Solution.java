// https://leetcode.com/problems/maximum-frequency-stack/description/
// using stack
// t.c.=O(1) for push and pop, s.c.=O(n)
lass FreqStack {
    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> group;
    int maxFreq;
    public FreqStack() {
        freq=new HashMap<>();
        group=new HashMap<>();
        maxFreq=0;
    }
    
    public void push(int val) {
        int f=freq.getOrDefault(val, 0)+1;
        freq.put(val, f);
        maxFreq=Math.max(maxFreq, f);
        group.computeIfAbsent(f, z->new Stack()).push(val);
    }
    
    public int pop() {
        int val=group.get(maxFreq).pop();
        freq.put(val, freq.get(val)-1);
        if(group.get(maxFreq).size()==0)
            maxFreq--;
        return val;
    }
}
