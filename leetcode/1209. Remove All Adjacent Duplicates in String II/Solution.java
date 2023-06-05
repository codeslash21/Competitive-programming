// using stack and custom ds
// t.c.=O(n), s.c.=O(n)

class Solution {
    static class Pair {
        Character c;
        Integer i;
        public Pair(Character c, Integer i) {
            this.c = c;
            this.i = i;
        }
    }
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();
        for(char ch:s.toCharArray()) {
            if(stack.isEmpty() || stack.peek().c!=ch)
                stack.push(new Pair(ch, 1));
            else if(stack.peek().c == ch)
                stack.push(new Pair(ch, stack.peek().i+1));
            if(stack.peek().i==k) {
                int j=k;
                while(j-->0)
                    stack.pop();
            }
        }
        String res = "";
        for(Pair pair:stack)
            res+=pair.c;
        return res;
    }
}

// Using two pointers
// t.c.=O(n), s.c.=O(1)

class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Integer> stack = new Stack<>();
        char[] ch = s.toCharArray();
        int j=0;
        for(int i=0;i<ch.length;i++,j++) {
            ch[j]=ch[i];
            if(j==0 || ch[j]!=ch[j-1])
                stack.push(1);
            else {
                int cnt = stack.pop()+1;
                if(cnt==k)
                    j=j-k;
                else
                    stack.push(cnt);
            }
        }
        return new String(ch, 0, j);
    }
}
