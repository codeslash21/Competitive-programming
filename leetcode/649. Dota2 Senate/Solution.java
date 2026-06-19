// https://leetcode.com/problems/dota2-senate/description/
// simulate the process
// t.c.=O(n^2), s.c.=O(n)
class Solution {
    public String predictPartyVictory(String senate) {
        List<Character> chars=new ArrayList<>();
        for(char ch:senate.toCharArray())
            chars.add(ch);
        while(true) {
            int i=0;
            while(i<chars.size()) {
                if(!chars.contains('D'))    return "Radiant";
                if(!chars.contains('R'))    return "Dire";
                int j=(i+1)%chars.size();
                if(chars.get(i)=='R') {
                    while(chars.get(j)=='R')
                        j=(j+1)%chars.size();
                } else {
                    while(chars.get(j)=='D')
                        j=(j+1)%chars.size();
                }
                chars.remove(j);
                if(j<i) i--;
                i++;
            }
        }
    }
}
