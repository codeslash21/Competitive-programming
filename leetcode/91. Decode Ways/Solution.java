// Using dp recursive approach
// t.c.O(n), s.c.=O(n)
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int numDecodings(String s) {
        return rec(s, 0);
    }
    public int rec(String s, int idx) {
        if(map.containsKey(idx))
            return map.get(idx);
        if(idx==s.length())
            return 1;
        if(s.charAt(idx)=='0')
            return 0;
        if(idx==s.length()-1)
            return 1;
        int val = rec(s, idx+1);
        if(Integer.parseInt(s.substring(idx, idx+2))<=26)
            val+=rec(s, idx+2);
        map.put(idx, val);
        return val;
    }
}

// Using dp iterative approach
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0')
            return 0;
        int n=s.length();
        int twoBack=1, oneBack=1;
        for(int i=1;i<n;i++) {
            int curr=0;
            if(s.charAt(i)!='0')
                curr=oneBack;
            int twoDigit = Integer.parseInt(s.substring(i-1, i+1));
            if(twoDigit>=10 && twoDigit<=26)
                curr+=twoBack;
            twoBack=oneBack;
            oneBack=curr;
        }
        return oneBack;
    }
}
