// using hashmap
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int n=s.length(), res=0;
        for(int i=n-1;i>=0;i--){
            int val=map.get(s.charAt(i));
            if(i<n-1 && val<map.get(s.charAt(i+1)))
                res-=val;
            else
                res+=val;
        }
        return res;
    }
}
