// Using stack and arraylist
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int compress(char[] chars) {
        List<Character> res = new ArrayList<>();
        int cnt=1, n=chars.length;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<n;i++) {
            if(i+1<n && chars[i]==chars[i+1])
                cnt+=1;
            else {
                res.add(chars[i]);
                if(cnt>1) {
                    while(cnt>0) {
                        stack.push((char)(cnt%10+'0'));
                        cnt/=10;
                    }
                    while(!stack.isEmpty())
                        res.add(stack.pop());
                    cnt=1;
                }
                
            }
        }
        for(int i=0;i<res.size();i++) 
            chars[i]=res.get(i);
        return res.size();
    }
}

// t.c.=O(n), s.c.=O(1)
class Solution {
    public int compress(char[] chars) {
        int i=0, res=0;
        while(i<chars.length) {
            int groupSize=1;
            while(i+groupSize<chars.length && chars[i+groupSize]==chars[i])
                groupSize++;
            chars[res++]=chars[i];
            if(groupSize>1) {
                for(char c:Integer.toString(groupSize).toCharArray())
                    chars[res++]=c;
            }
            i+=groupSize;
        }
        return res;
    }
}
