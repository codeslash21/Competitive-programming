// t.c.=O(n), s.c.=O(1)
class Solution {
    public int maxDepth(String s) {
        int res=0, curr=0;
        for(char c:s.toCharArray()) {
            if(c=='(')
                curr++;
            else if(c==')')
                curr--;
            if(res<curr)
                res=curr;
        }
        return res;
    }
}
